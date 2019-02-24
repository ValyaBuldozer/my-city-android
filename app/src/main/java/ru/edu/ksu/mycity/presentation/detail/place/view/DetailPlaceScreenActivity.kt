package ru.edu.ksu.mycity.presentation.detail.place.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import ru.edu.ksu.mycity.App
import ru.edu.ksu.mycity.R
import ru.edu.ksu.mycity.databinding.ActivityDetailPlaceScreenBinding
import ru.edu.ksu.mycity.helpers.arch.base.BaseActivity
import ru.edu.ksu.mycity.helpers.view.extensions.linearlayout.bindQuizAnswers
import ru.edu.ksu.mycity.helpers.view.extensions.linearlayout.bindRoutesList
import ru.edu.ksu.mycity.presentation.common.quiz.answer.dialog.fragment.QuizAnswerDialogFragment
import ru.edu.ksu.mycity.presentation.detail.place.contracts.DetailPlaceVmContract
import ru.edu.ksu.mycity.presentation.detail.place.interactor.DetailPlaceScreenInteractor
import ru.edu.ksu.mycity.presentation.detail.place.presenter.DetailPlaceScreenPresenter
import ru.edu.ksu.mycity.presentation.detail.place.router.DetailPlaceScreenRouter
import ru.edu.ksu.mycity.presentation.detail.place.viewmodel.DetailPlaceScreenVm

class DetailPlaceScreenActivity : BaseActivity<DetailPlaceVmContract.Presenter, DetailPlaceVmContract.ViewModel>() {

    companion object {

        const val PLACE_ID_NAME = "PLACE_ID"

        fun createIntent(context: Context, placeId: Int) =
                Intent(context, DetailPlaceScreenActivity::class.java).apply {
                    putExtra(PLACE_ID_NAME, placeId)
                }
    }

    private lateinit var binding: ActivityDetailPlaceScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_place_screen)
        binding.setLifecycleOwner(this@DetailPlaceScreenActivity)
        binding.viewModel = viewModel

        binding.detailPlaceScreenShowButton.setOnClickListener(this::showDescriptionClickHandler)
        binding.detailPlaceAppBar.appbarGoBackBtn.setOnClickListener(this::goBackClickHandler)
    }

    override fun createPresenter(): DetailPlaceVmContract.Presenter =
        DetailPlaceScreenPresenter(
            DetailPlaceScreenInteractor(App.get().getNetworkService()),
            DetailPlaceScreenRouter(),
            intent.extras.getInt(PLACE_ID_NAME)
        )

    override fun createViewModel(): DetailPlaceVmContract.ViewModel = DetailPlaceScreenVm()

    override fun createSubscribers() {
        viewModel.placeRoutes.observe(this, Observer { routeList ->
            routeList?.let {
                binding.detailPlaceScreenRoutes.bindRoutesList(routeList) { routeInfo ->
                    presenter.onRouteClick(routeInfo)
                }
            }
        })

        viewModel.placeQuizAnswers.observe(this, Observer { answersList ->
            answersList?.let {
                binding.detailPlaceScreenQuizAnswers.bindQuizAnswers(answersList) { answer ->
                    presenter.onQuizAnswerClick(answer)
                }
            }
        })

        viewModel.currentAnswer.observe(this, Observer { answer ->
            answer?.let {
                QuizAnswerDialogFragment.create(answer.isRight, answer.description)
                    .show(this@DetailPlaceScreenActivity.fragmentManager, "answer_dialog")
            }
        })
    }

    private fun showDescriptionClickHandler(view: View) {
        presenter.onShowDescriptionClick()
    }

    private fun goBackClickHandler(view: View) {
        presenter.onGoBackClick()
    }
}
