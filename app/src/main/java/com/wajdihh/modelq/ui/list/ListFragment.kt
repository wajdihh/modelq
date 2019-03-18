package com.wajdihh.modelq.ui.list

import android.content.SharedPreferences
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.wajdihh.domain.request.SearchRequest
import com.wajdihh.modelq.R
import com.wajdihh.modelq.application.MyApplication
import com.wajdihh.modelq.ui.BaseFragment
import com.wajdihh.modelq.ui.BaseRecycleViewAdapter
import com.wajdihh.modelq.ui.Router
import com.wajdihh.modelq.utils.AlertUtils
import com.wajdihh.presentation.model.DemandItemUi
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
    @Inject
    lateinit var sharedPreferences: SharedPreferences

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
        adapter.setOnClickRowListener(object : BaseRecycleViewAdapter.OnClickRowListener<DemandItemUi> {
            override fun onClickRow(v: View, position: Int, currentItem: DemandItemUi) {
                simulateLogin()
                Router.navigateToDetail(activity, currentItem.id)
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
        AlertUtils.showAlertError(context, throwable.localizedMessage)
    }

    /**
     * Just method is to add the xToken to the header, because the details web service is consumed with authenticated user
     */
    private fun simulateLogin() {
        val xContext = "eyJhZHZlcnRpc2VyX3RyYWNraW5nX2VuYWJsZWQiOmZhbHNlLCJwbGF0Zm9ybSI6ImFuZHJvaWQiLCJhcHBzZmx5ZXJfaWQiOiIxNTQ0MTc1NTYwOTI2LTgwNDEwNTg2NTI4NjMxMTQzNDgiLCJidW5kbGVfdmVyc2lvbiI6IjYuMTAuMS4xIiwiYXBwbGljYXRpb25fdHJhY2tpbmdfZW5hYmxlZCI6ZmFsc2UsInVzZXJfaWQiOiIiLCJhcHBfaWQiOiJjb20uc3Rvb3RpZS5kZWJ1ZyIsImZhY2Vib29rX2FwcF9pZCI6IjEzNjE1NzEwMzEyNDUzMSIsImFkdmVydGlzaW5nX2lkIjoiOGExYjJlNDYtYjNjMS00ODM0LWFlZDItMGUzZDNkYzkxMGE0In0="
        sharedPreferences.edit().putString(getString(R.string.pref_user_access_token), xContext).apply()
    }
}

