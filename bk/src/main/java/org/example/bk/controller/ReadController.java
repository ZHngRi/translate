package org.example.bk.controller;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.impl.CreatorCandidate;
import com.openai.models.responses.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Request;
import org.example.trcommon.R.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.responses.ResponseOutputMessage.Content;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/trans")
public class ReadController {

    @Autowired
    OpenAIClient client;


    @PostMapping("/hello")
    //  *   匹配任意多的字符    /hello*  ==> /hello1sds23
    //  **  匹配任意多的路径    /hello**  ==> /hello/a  /hello/a/b      双星不能放中间
    //  ?   匹配一个字符       /hello?  ==> /helloa
    //  优先级：        完全匹配  >  ?   >   *   > **
    public String hello(){
        return "Hello Spring MVC!";
    }

    @PostMapping("trans")
    public R trans(@RequestParam("var")String var){
        log.info("开始翻译文本{}",var);

        ResponseCreateParams params = ResponseCreateParams.builder()
                .model("gpt-5.3-codex")
                .input("帮我翻译一下这是什么意思"+var)
                .build();

        String text = "";
        List<ResponseOutputItem> items = client.responses().create(params).output();
        for (ResponseOutputItem item : items) {

            Optional<ResponseOutputMessage> messageOptional = item.message();

            if (messageOptional.isPresent()) {

                ResponseOutputMessage message = messageOptional.get();

                List<Content> contents = message.content();

                for (Content content : contents) {

                    Optional<ResponseOutputText> textOptional = content.outputText();

                    if (textOptional.isPresent()) {

                        ResponseOutputText outputText = textOptional.get();

                        text = outputText.text();

                        break;   // 找到第一个就结束
                    }
                }
            }

            if (!text.equals("")) {
                break;
            }
        }
//        String text = client.responses().create(params).output().stream()
//                .flatMap(item -> item.message().stream())
//                .flatMap(message -> message.content().stream())
//                .flatMap(content -> content.outputText().stream())
//                .map(outputText -> outputText.text())
//                .findFirst()
//                .orElse("");

        log.info("开始翻译结果{}",text);
        return R.ok(text);
    }
    @PostMapping("transstring")
    public  String transstring(@RequestParam("var")String var){
        OpenAIClient client = OpenAIOkHttpClient.builder().
                apiKey("sk-t0yv1VPpAH115Zre4Aozox4clFL36Ddf3FlCiljP8qcI18n4").
                baseUrl("https://bobdong.cn/v1").
                build();
        ResponseCreateParams params = ResponseCreateParams.builder()
                .input("帮我翻译一下这是什么意思"+var)
                .model("gpt-5.3-codex")
                .build();

        Response response = client.responses().create(params);

        String text = response.toString();

        return text;
    }



}
