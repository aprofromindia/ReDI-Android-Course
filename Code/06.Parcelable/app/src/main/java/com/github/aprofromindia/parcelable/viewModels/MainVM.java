package com.github.aprofromindia.parcelable.viewModels;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;

import com.android.databinding.library.baseAdapters.BR;
import com.github.aprofromindia.parcelable.databinding.ActivityMainBinding;
import com.github.aprofromindia.parcelable.entities.EMail;

/**
 * Created by achoudh on 20/12/2016.
 */

public class MainVM extends BaseObservable {

    private EMail eMail = new EMail("harry", "body");;
    private ActivityMainBinding binding;
    private boolean isBtnClicked;

    public MainVM(ActivityMainBinding binding) {
        this.binding = binding;
    }

    @Bindable
    public EMail getEMail() {
        return eMail;
    }

    @Bindable
    public boolean isBtnClicked() {
        return isBtnClicked;
    }

    public void btnClicked(View view) {
        isBtnClicked = true;
        notifyPropertyChanged(BR.btnClicked);
    }
}
