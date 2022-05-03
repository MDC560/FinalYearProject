package com.example.finalproject.util

import android.content.Context
import androidx.appcompat.app.AlertDialog
import com.example.finalproject.callback.DialogCallBack

object Utility {

     fun showAlertDialogWithCallBack(context: Context, title: String, message: String, dialogCallBack: DialogCallBack?=null) {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setNegativeButton("No") { dialogInterface, i ->
                run {
                    dialogCallBack?.let {
                        it.onNegtiveButtonClick()
                        dialogInterface.dismiss()
                    }
                }
            }
            .setPositiveButton("OK")
            { dialogInterface, i ->
                run {
                    dialogCallBack?.let {
                        it.onPositiveButonClick()
                        dialogInterface.dismiss()
                    }
                }
            }.create().show()
    }
}