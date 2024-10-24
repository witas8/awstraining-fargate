package com.awstraining.backend.business.notifyme;

import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyMeService {

    private MessageSender sender;
    private AmazonTranslate translate;

    // TODO: lab1
    //  1. Inject MessageSender.
    // TODO lab2
    //  1. Inject Translator
    // TODO lab3
    //  1. Inject sentiment detector
    @Autowired
    public NotifyMeService(MessageSender sender, AmazonTranslate amazonTranslate) {
        this.sender = sender;
        this.translate = amazonTranslate;
    }

    public String notifyMe(NotifyMeDO notifyMe) {

        // TODO: lab1
        //  1. Send text using sender.
        //  2. Return sent message.
        // TODO: lab2
        //  1. Translate text from using translator.
        //  2. Change sending of text to "translated text" and return it.
        // TODO: lab3
        //  1. Detect sentiment of translated message.
        //  2. Change sending of text to "setiment: translated text" and return it.
        final String text = notifyMe.text();
        TranslateTextRequest translateTextRequest = new TranslateTextRequest().withText(text)
                .withSourceLanguageCode(notifyMe.sourceLc()).withTargetLanguageCode(notifyMe.targetLc());
        TranslateTextResult translateTextResult = translate.translateText(translateTextRequest);
        sender.send(translateTextResult.getTranslatedText());
        return text;
    }
    
}
