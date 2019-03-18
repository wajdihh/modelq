package com.wajdihh.modelq.utils

import android.app.AlertDialog
import android.content.Context
import com.wajdihh.modelq.R


class AlertUtils {
    companion object {
        fun showAlertError(context: Context, message: String) {
            AlertDialog.Builder(context)
                    .setTitle(context.getString(R.string.alert_error_title))
                    .setMessage(message)
                    .setPositiveButton(android.R.string.yes, null)
                    .show()
        }
    }
}