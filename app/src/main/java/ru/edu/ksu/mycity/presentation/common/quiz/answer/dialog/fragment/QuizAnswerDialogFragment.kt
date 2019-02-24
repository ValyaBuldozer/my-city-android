package ru.edu.ksu.mycity.presentation.common.quiz.answer.dialog.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment

import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.FragmentQuizAnswerBinding

class QuizAnswerDialogFragment : DialogFragment() {

    companion object {
        private const val DESCRIPTION = "description"
        private const val IS_RIGHT = "is_right"

        fun create() = QuizAnswerDialogFragment()

        fun create(isRight: Boolean, description: String) =
            QuizAnswerDialogFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(IS_RIGHT, isRight)
                    putString(DESCRIPTION, description)
                }
            }
    }

    private lateinit var binding: FragmentQuizAnswerBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = DataBindingUtil.inflate<FragmentQuizAnswerBinding>(
            activity!!.layoutInflater,
            R.layout.fragment_quiz_answer,
            null,
            false
        ).apply {
            isRight = arguments?.getBoolean(IS_RIGHT, false)
            description = arguments?.getString(DESCRIPTION, "")
            quizAnswerBtnOk.setOnClickListener {
                this@QuizAnswerDialogFragment.dialog.hide()
            }
        }

        return AlertDialog.Builder(requireContext())
            .setView(binding.root)
            .create()
    }

    override fun onResume() {
        super.onResume()

        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
}
