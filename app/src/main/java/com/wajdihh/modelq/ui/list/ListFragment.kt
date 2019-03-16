package com.wajdihh.modelq.ui.list

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.modelq.R
import com.wajdihh.modelq.application.MyApplication
import com.wajdihh.modelq.ui.BaseFragment
import com.wajdihh.modelq.ui.BaseRecycleViewAdapter
import com.wajdihh.presentation.model.DemandsPagingUi
import com.wajdihh.presentation.mvp.demand.list.DemandListPresenter
import com.wajdihh.presentation.mvp.demand.list.DemandListView
import kotlinx.android.synthetic.main.fragment_list.*
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

    private lateinit var adapter: ListAdapter
    //Data statiques pour le moment
    private val params = SearchRequest(lat = 48.8694023,
            lng = 2.3522692,
            radius = 50,
            type = "mission",
            page = 1,
            perPage = 20)

    override fun getLayoutResources() = R.layout.fragment_list

    override fun onPostCreateView() {
        //Dagger
        MyApplication.uiComponent.inject(this)
        presenter.attachView(this)

        //Set list
        adapter = ListAdapter()
        demandsRecycleView.layoutManager = LinearLayoutManager(activity)
        demandsRecycleView.adapter = adapter
        adapter.setOnClickRowListener(object : BaseRecycleViewAdapter.OnClickRowListener {
            override fun onClickRow(v: View, position: Int) {
                Toast.makeText(activity, "CLick rowww", Toast.LENGTH_LONG).show()
            }
        })
        adapter.setOnLoadMoreListener(object : BaseRecycleViewAdapter.OnLoadMoreListener {
            override fun onLoadMore() {
                presenter.loadMoreDemands(adapter.itemCount)
            }
        })

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
        adapter.appendList(ArrayList(demandsPagingUi.demands), demandsPagingUi.total)
    }

    override fun onErrorLoadList(throwable: Throwable) {
        Toast.makeText(activity, "Operation finished with error", Toast.LENGTH_SHORT).show()
    }
}

