package com.wajdihh.modelq.ui.list

import android.widget.Toast
import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.modelq.R
import com.wajdihh.modelq.application.MyApplication
import com.wajdihh.modelq.ui.BaseFragment
import com.wajdihh.presentation.model.DemandsPagingUi
import com.wajdihh.presentation.mvp.demand.list.DemandListPresenter
import com.wajdihh.presentation.mvp.demand.list.DemandListView
import javax.inject.Inject

/**
 * Created by wajdihh on 3/13/19.
 * ListFragment
 */
class ListFragment : BaseFragment(), DemandListView {
    companion object {
        fun newInstance() = ListFragment()
    }

    @Inject
    lateinit var presenter : DemandListPresenter

    //Data statiques pour le moment
    private val params = SearchRequest(lat = 48.8694023,
            lng = 2.3522692,
            radius = 50,
            type = "mission",
            page = 1,
            perPage = PER_PAGE)


    override fun getLayoutResources() = R.layout.fragment_list

    override fun onPostCreateView() {
        //Dagger
        MyApplication.uiComponent.inject(this)
        presenter.attachView(this)

        //Launch the use case to get the list
        presenter.searchForDemands(params)

    }
    override fun isViewAttached(): Boolean = isAttachedToMainActivity()

    override fun onShowProgress() {
        showProgress()
    }

    override fun onHideProgress() {
        hideProgress()
    }

    override fun onSuccessLoadList(demandsPagingUi: DemandsPagingUi) {
        Toast.makeText(activity, "Total is ${demandsPagingUi.total}", Toast.LENGTH_SHORT).show()
    }

    override fun onErrorLoadList(throwable: Throwable) {
        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
    }

}

const val PER_PAGE = 50

