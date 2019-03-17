package com.wajdihh.modelq.ui.detail

import android.widget.Toast
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso
import com.wajdihh.modelq.R
import com.wajdihh.modelq.application.MyApplication
import com.wajdihh.modelq.extension.bundle
import com.wajdihh.modelq.extension.hide
import com.wajdihh.modelq.extension.show
import com.wajdihh.modelq.ui.BaseFragment
import com.wajdihh.modelq.utils.CircleTransform
import com.wajdihh.presentation.model.DemandUi
import com.wajdihh.presentation.mvp.demand.detail.DemandDetailPresenter
import com.wajdihh.presentation.mvp.demand.detail.DemandDetailView
import kotlinx.android.synthetic.main.fragment_detail.*
import javax.inject.Inject

/**
 * Created by wajdihh on 3/16/19.
 * Details
 */
class DetailFragment : BaseFragment(), DemandDetailView, OnMapReadyCallback {


    companion object {
        const val ARG_DEMAND_ID = "ARG_DEMAND_ID"
        fun newInstance(id: Int) = DetailFragment().apply {
            arguments = bundle { putInt(ARG_DEMAND_ID, id) }
        }
    }

    @Inject
    lateinit var presenter: DemandDetailPresenter
    private var locPoint = LatLng(0.0, 0.0)

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
        detailsContainer.hide()
    }

    override fun onHideProgress() {
        hideProgress()
        detailsContainer.show()
    }

    override fun onSuccessLoadDetails(demand: DemandUi) {
        //user block
        buildUserBlock(demand)
        //Others
        buildDetailsBlock(demand)
    }

    override fun onErrorLoadDetails(throwable: Throwable) {
        Toast.makeText(activity, "Operation finished with error", Toast.LENGTH_SHORT).show()
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap ?: return
        with(googleMap) {
            moveCamera(CameraUpdateFactory.newLatLngZoom(locPoint, 15f))
            addMarker(MarkerOptions().position(locPoint))
        }
    }

    private fun buildUserBlock(demand: DemandUi) {
        //Image
        Picasso.with(activity)
                .load(demand.user?.profileThumbUrl)
                .transform(CircleTransform())
                .placeholder(R.drawable.default_avatar_large)
                .error(R.drawable.default_avatar_large)
                .into(detailsUserPic)
        //Name
        detailsUserName.text = demand.user?.fullName
        //Eval
        detailsUserEval.text = getString(R.string.details_user_eval, demand.user?.evalCount)
    }

    private fun buildDetailsBlock(demand: DemandUi) {
        //title
        detailsTitle.text = demand.title
        //price
        detailsPrice.text = getString(R.string.price_prefix, demand.price)
        //description
        detailsDescription.text = demand.description
        //address
        detailsAddress.text = demand.address
        //Point
        locPoint = LatLng(demand.lat, demand.lng)
        //Load map
        val mapFragment = childFragmentManager.findFragmentById(R.id.map)  as? MapFragment
        mapFragment?.getMapAsync(this)
    }
}