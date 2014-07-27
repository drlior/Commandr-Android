package com.RSen.Commandr.builtincommands;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.widget.Toast;

import com.RSen.Commandr.R;
import com.RSen.Commandr.core.MostWantedCommand;
import com.RSen.Commandr.util.PandoraBotsUtil;
import com.RSen.Commandr.util.SMSUtils;
import com.RSen.Commandr.util.SmsMmsMessage;
import com.RSen.Commandr.util.TTSService;

import java.util.ArrayList;

/**
 * @author Ryan Senanayake
 *         Commandr for Google Now
 *         FlashlightCommand.java
 * @version 1.0
 *          5/28/14
 */
public class ChatbotCommand extends MostWantedCommand {

    private static String TITLE;
    private static String DEFAULT_PHRASE;
    private Context context;
    public ChatbotCommand(Context ctx) {
        DEFAULT_PHRASE = ctx.getString(R.string.chatbot_phrases);
        TITLE = ctx.getString(R.string.chatbot_title);
        context = ctx;
    }

    /**
     * Execute this command (turn on flashlight)
     */
    @Override
    public void execute(Context context, String predicate) {
        Toast.makeText(context, context.getString(R.string.fetch_response), Toast.LENGTH_LONG).show();
            PandoraBotsUtil.askPandorabots(context, predicate);
    }

    /**
     * It is enabled if the phone has a flash feature
     */
    @Override
    public boolean isAvailable(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_TELEPHONY);
    }
    @Override
    public String getPredicateHint() {
        return context.getString(R.string.chatbot_predicate_hint);
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public String getDefaultPhrase() {
        return DEFAULT_PHRASE;
    }


}