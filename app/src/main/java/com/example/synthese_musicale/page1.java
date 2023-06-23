package com.example.synthese_musicale;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link page1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class page1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private BluetoothAdapter BTAdapter;
    private BluetoothSocket bTSocket;
    private BluetoothDevice mmDevice;
    private InputStream mmInStream;
    public static OutputStream mmOutStream;
    private byte[] mmBuffer;
    private Handler handler;
    //private ArrayList<DeviceItem> deviceItemList;
    public static int REQUEST_BLUETOOTH = 1;
    private View vue;
    private Button scan, appareil;
    private TextView adresse;
    private interface MessageConstants {
        public static final int MESSAGE_READ = 0;
        public static final int MESSAGE_WRITE = 1;
        public static final int MESSAGE_TOAST = 2;

        // ... (Add other message types here as needed.)
    }
    Fragment page2;
    Activity main;
    //private DeviceItem newDevice;
    String addresse, nom, uuid;

    protected boolean test ;
    String texte = " ";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private void lanceFragment(Fragment fragment) {
        FragmentManager fm =getActivity().getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ft.replace(R.id.frame,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment page1.
     */
    // TODO: Rename and change types and number of parameters
    public static page1 newInstance(String param1, String param2) {
        page1 fragment = new page1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        vue = inflater.inflate(R.layout.fragment_page1, container, false);
        BTAdapter = BluetoothAdapter.getDefaultAdapter();
        scan = (Button) vue.findViewById(R.id.scan_button);
        appareil = (Button) vue.findViewById(R.id.appareil);
        adresse = (TextView) vue.findViewById(R.id.addresse);

        Log.d("test", "valeur :" + test);

        if (!BTAdapter.isEnabled()) {
            Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBT, REQUEST_BLUETOOTH);
        }
        Log.d("DEVICELIST", "Super called for DeviceListFragment onCreate\n");

        //deviceItemList = new ArrayList<DeviceItem>();

        if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        }
        Set<BluetoothDevice> pairedDevices = BTAdapter.getBondedDevices();
        Log.i("BT", "Nombre d'appareil associe : " + pairedDevices.size());
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                if (device.getName().equals("IT2R04")) {
                    addresse = device.getAddress();
                    nom = device.getName();
                    //newDevice = new DeviceItem(device.getName(), device.getAddress(), "false");
                    //deviceItemList.add(newDevice);
                    Log.i("BT", "adresse : " + addresse);
                    Log.i("BT", "NOM : " + nom);
                    mmDevice=device;
                    Toast.makeText(getContext(), "Module Bluetooth detected", Toast.LENGTH_SHORT).show();
                }

            }
        } else {
            Toast.makeText(getContext(), "Module Bluetooth not detected", Toast.LENGTH_LONG).show();
        }
        scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ActivityCompat.checkSelfPermission(getContext(), android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
                Set<BluetoothDevice> pairedDevices = BTAdapter.getBondedDevices();
                Log.i("BT", "Nombre d'appareil associe : " + pairedDevices.size());
                if (pairedDevices.size() > 0) {
                    for (BluetoothDevice device : pairedDevices) {
                        if (device.getName().equals("IT2R04")) {

                            addresse = device.getAddress();
                            nom = device.getName();
                            mmDevice=device;
                        }
                        //newDevice = new DeviceItem(device.getName(), device.getAddress(), "false");
                        //deviceItemList.add(newDevice);
                        Log.i("BT", "adresse : " + addresse);
                        Log.i("BT", "NOM : " + nom);
                        Toast.makeText(getContext(), "Appareils detecte", Toast.LENGTH_SHORT).show();
                        appareil.setText("Name : " + nom);
                        adresse.setText("Adresse : " + addresse);

                    }
                }
            }

        });

        appareil.setText("Name : " + nom);
        adresse.setText("Adresse : " + addresse);
        BTAdapter.cancelDiscovery();

        appareil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BluetoothSocket tmp = null;

                try {
                    // Get a BluetoothSocket to connect with the given BluetoothDevice.
                    // MY_UUID is the app's UUID string, also used in the server code.
                    tmp = mmDevice.createRfcommSocketToServiceRecord(UUID.fromString("00001101-0000-1000-8000-00805F9B34FB"));
                    Log.i("BT","Socket created");
                    Toast toast = Toast.makeText(getContext(), "Socket created", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                } catch (IOException e) {
                    Log.e("BT", "Socket's create() method failed", e);
                }
                bTSocket = tmp;
                InputStream tmpIn = null;
                OutputStream tmpOut = null;
                try {
                    tmpIn = bTSocket.getInputStream();
                } catch (IOException e) {
                    Log.e("BT", "Error occurred when creating input stream", e);
                }
                try {
                    tmpOut = bTSocket.getOutputStream();
                } catch (IOException e) {
                    Log.e("BT", "Error occurred when creating output stream", e);
                }
                mmInStream = tmpIn;
                mmOutStream = tmpOut;


                try {
                    // Connect to the remote device through the socket. This call blocks
                    // until it succeeds or throws an exception.
                    Toast.makeText(getContext(), "Connexion....", Toast.LENGTH_LONG).show();
                    bTSocket.connect();
                    page2 = new page2();
                    ((com.example.synthese_musicale.page2) page2).mmOutStream = mmOutStream;
                    lanceFragment(new page2());

                } catch (IOException connectException) {
                    Toast.makeText(getContext(), "Unable to connect to the device", Toast.LENGTH_LONG).show();// Unable to connect; close the socket and return.
                    try {
                        bTSocket.close();
                    } catch (IOException closeException) {
                        Log.e("SOCKET", "Could not close the client socket", closeException);
                    }

                }
                Log.i("BT", "Status connexion : " + bTSocket.isConnected());



            }


        });

        return vue;

    }
    public void write(byte[] bytes) {
        try {

            mmBuffer = new byte[1024];

            mmOutStream.write(bytes);

            Log.i("BT", "Donnes envoyes " );
            // Share the sent message with the UI activity.
            /*Message writtenMsg = handler.obtainMessage(
                    MessageConstants.MESSAGE_WRITE, -1, -1, mmBuffer);
            writtenMsg.sendToTarget();*/
        } catch (IOException e) {
            Log.e("BT", "Error occurred when sending data", e);

            // Send a failure message back to the activity.
            /*Message writeErrorMsg =
                    handler.obtainMessage(MessageConstants.MESSAGE_TOAST);
            Bundle bundle = new Bundle();
            bundle.putString("toast",
                    "Couldn't send data to the other device");
            writeErrorMsg.setData(bundle);
            handler.sendMessage(writeErrorMsg);*/
        }
    }
}


