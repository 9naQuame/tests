package com.example.mytrialapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class AlertDialogManager {
    /**
     * Function to display simple Alert Dialog
     * <a class="_hootified" a="" href="http://twitter.com/#!/@param" onclick="javascript:var e = document.createEvent("CustomEvent"); e.initCustomEvent("hootletEvent", true, true, {type: "userHandle", value: "@param"});  document.body.dispatchEvent(e); return false;">@param</a> context - application context
     * <a class="_hootified" a="" href="http://twitter.com/#!/@param" onclick="javascript:var e = document.createEvent("CustomEvent"); e.initCustomEvent("hootletEvent", true, true, {type: "userHandle", value: "@param"});  document.body.dispatchEvent(e); return false;">@param</a> title - alert dialog title
     * <a class="_hootified" a="" href="http://twitter.com/#!/@param" onclick="javascript:var e = document.createEvent("CustomEvent"); e.initCustomEvent("hootletEvent", true, true, {type: "userHandle", value: "@param"});  document.body.dispatchEvent(e); return false;">@param</a> message - alert message
     * <a class="_hootified" a="" href="http://twitter.com/#!/@param" onclick="javascript:var e = document.createEvent("CustomEvent"); e.initCustomEvent("hootletEvent", true, true, {type: "userHandle", value: "@param"});  document.body.dispatchEvent(e); return false;">@param</a> status - success/failure (used to set icon)
     *               - pass null if you don't want icon
     * */
    public void showAlertDialog(Context context, String title, String message,
            Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
 
        // Setting Dialog Title
        alertDialog.setTitle(title);
 
        // Setting Dialog Message
        alertDialog.setMessage(message);
 
        if(status != null)
            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);
 
        // Setting OK Button
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
 
        // Showing Alert Message
        alertDialog.show();
    }
}