package com.wajdihh.modelq.ui.detail

import android.widget.Toast
import com.wajdihh.modelq.R
import com.wajdihh.modelq.application.MyApplication
import com.wajdihh.modelq.extension.bundle
import com.wajdihh.modelq.ui.BaseFragment
import com.wajdihh.presentation.model.DemandUi
import com.wajdihh.presentation.mvp.demand.detail.DemandDetailPresenter
import com.wajdihh.presentation.mvp.demand.detail.DemandDetailView
import javax.inject.Inject

/**
 * Created by wajdihh on 3/16/19.
 * Details
 */
class DetailFragment : BaseFragment(), DemandDetailView {

    companion object {
        const val ARG_DEMAND_ID = "ARG_DEMAND_ID"

        fun newInstance(id: Int) = DetailFragment().apply {
            arguments = bundle { putInt(ARG_DEMAND_ID, id) }
        }
    }

    @Inject
    lateinit var presenter: DemandDetailPresenter

    override fun getLayoutResources() = R.layout.fragment_detail

    override fun onPostCreateView() {
        //Dagger
        MyApplication.uiComponent.inject(this)
        presenter.attachView(this)
        //Load details
        val id = arguments.getInt(ARG_DEMAND_ID)
        presenter.getDetails(id)

    }

    override fun isViewAttached(): Boolean = isAttachedToMainActivity()

    override fun onShowProgress() {
        showProgress()
    }

    override fun onHideProgress() {
        hideProgress()
    }

    override fun onSuccessLoadDetails(demand: DemandUi) {
        Toast.makeText(activity, "Success detail" + demand.title, Toast.LENGTH_SHORT).show()
    }

    override fun onErrorLoadDetails(throwable: Throwable) {
        Toast.makeText(activity, "Operation finished with error", Toast.LENGTH_SHORT).show()
    }
}