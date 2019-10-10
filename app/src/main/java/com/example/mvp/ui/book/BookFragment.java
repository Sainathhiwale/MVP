package com.example.mvp.ui.book;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mvp.R;
import com.example.mvp.adapter.ViewPagerAdapter;
import com.example.mvp.ui.book.addbook.AddBookFragment;
import com.example.mvp.ui.book.allbook.GetAllBookFragment;
import com.example.mvp.ui.book.deletebook.DeleteBookFragment;
import com.example.mvp.ui.book.putbook.PutBookFragment;
import com.example.mvp.ui.book.singlebook.SingleBookFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class BookFragment extends Fragment {
    private static final String TAG = "BookFragment";

    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 101;
    @Bind(R.id.tab_layout_book)
    TabLayout tabLayoutBook;
    @Bind(R.id.viewpager_book)
    ViewPager viewpagerBook;
    @Bind(R.id.llBookLayout)
    LinearLayout llBookLayout;

    public BookFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        // checkAndRequestPermissions();
        initView();
        ButterKnife.bind(this, view);
        return view;
    }

    private void initView() {
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Book");
        setupPager(viewpagerBook);
    }

    private void setupPager(ViewPager viewpagerBook) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new AddBookFragment(),"Add Book");
        viewPagerAdapter.addFragment(new SingleBookFragment(),"Single Book");
        viewPagerAdapter.addFragment(new GetAllBookFragment(),"All Book");
        viewPagerAdapter.addFragment(new DeleteBookFragment(),"Delete Book");
        viewPagerAdapter.addFragment(new PutBookFragment(),"Put Book");
        viewpagerBook.setAdapter(viewPagerAdapter);
    }


}


/* private boolean checkAndRequestPermissions() {
        int premissionSendMessage = ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS);
        int locationPremission = ContextCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION);
        List<String> listPermissionsNeeded = new ArrayList<>();

        if (locationPremission!= PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (premissionSendMessage!= PackageManager.PERMISSION_GRANTED){
            listPermissionsNeeded.add(Manifest.permission.SEND_SMS);
        }
        if (!listPermissionsNeeded.isEmpty()){
            ActivityCompat.requestPermissions(getActivity(),listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
         return true;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG, "Permission callback called-------");
        switch (requestCode){
            case REQUEST_ID_MULTIPLE_PERMISSIONS:{
                Map<String,Integer> prems = new HashMap<>();
                // Initialize the map with both permissions
                prems.put(Manifest.permission.SEND_SMS,PackageManager.PERMISSION_GRANTED);
                prems.put(Manifest.permission.ACCESS_FINE_LOCATION,PackageManager.PERMISSION_GRANTED);

                if (grantResults.length>0){
                    for (int i=0;i<permissions.length;i++){
                        prems.put(permissions[i],grantResults[i]);
                        // Check for both permissions

                        if (prems.get(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
                                && prems.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                            Log.d(TAG, "sms & location services permission granted");
                            // process the normal flow
                            //else any one or both the permissions are not granted
                        }else {
                            Log.d(TAG, "Some permissions are not granted ask again ");
                            //permission is denied (this is the first time, when "never ask again" is not checked) so ask again explaining the usage of permission
//                        // shouldShowRequestPermissionRationale will return true
                            //show the dialog or snackbar saying its necessary and try again otherwise proceed with setup.
                          if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.SEND_SMS) || ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)){
                              showDialogOK("SMS and Location Services Permission required for this app",
                                      new DialogInterface.OnClickListener() {
                                          @Override
                                          public void onClick(DialogInterface dialog, int which) {
                                              switch (which) {
                                                  case DialogInterface.BUTTON_POSITIVE:
                                                      checkAndRequestPermissions();
                                                      break;
                                                  case DialogInterface.BUTTON_NEGATIVE:
                                                      // proceed with logic by disabling the related features or quit the app.
                                                      break;
                                              }
                                          }
                              });
                          }else {
                              Toast.makeText(getActivity(), "Go to settings and enable permissions", Toast.LENGTH_LONG)
                                      .show();
                              //                            //proceed with logic by disabling the related features or quit the app.
                          }

                        }
                    }
                }
            }

        }

    }

    private void showDialogOK(String message, DialogInterface.OnClickListener onClickListener) {
        new AlertDialog.Builder(getActivity())
                .setMessage(message)
                .setPositiveButton("Ok",onClickListener)
                .setNegativeButton("Cancel", onClickListener)
                .create()
                .show();
    }
*/