package com.example.assetfinance.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.assetfinance.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.nbsp.materialfilepicker.MaterialFilePicker;
import com.nbsp.materialfilepicker.ui.FilePickerActivity;
import com.shockwave.pdfium.PdfDocument;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class AttachmentsActivity extends AppCompatActivity implements View.OnClickListener, OnPageChangeListener, OnLoadCompleteListener,
        OnPageErrorListener {
    @BindView(R.id.proceedNine)
    Button proceedNineBtn;
    private String pdfFileName;
    private PDFView pdfView;
    public ProgressDialog pDialog;
    public static final int FILE_PICKER_REQUEST_CODE = 1;
    private String pdfPath;

    private int pageNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attachments);
        ButterKnife.bind(this);
        setTitle("9. APPLICATION ATTACHMENTS");
        pdfView = (PDFView) findViewById(R.id.pdfView);
        initDialog();
        proceedNineBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.pickFile:
                launchPicker();
                return true;
            case R.id.upload:
//                uploadFile();
                return true;
        }

        return(super.onOptionsItemSelected(item));
    }

//    private void uploadFile() {
//        if (pdfPath == null) {
//            Toast.makeText(this, "please select an image ", Toast.LENGTH_LONG).show();
//            return;
//        } else {
//            showpDialog();
//
//            // Map is used to multipart the file using okhttp3.RequestBody
//            Map<String, RequestBody> map = new HashMap<>();
//            File file = new File(pdfPath);
//            // Parsing any Media type file
//            RequestBody requestBody = RequestBody.create(MediaType.parse("application/pdf"), file);
//            map.put("file\"; filename=\"" + file.getName() + "\"", requestBody);
//            ApiConfig getResponse = AppConfig.getRetrofit().create(ApiConfig.class);
//            Call<ServerResponse> call = getResponse.upload("token", map);
//            call.enqueue(new Callback<ServerResponse>() {
//                @Override
//                public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
//                    if (response.isSuccessful()){
//                        if (response.body() != null){
//                            hidepDialog();
//                            ServerResponse serverResponse = response.body();
//                            Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
//
//                        }
//                    }else {
//                        hidepDialog();
//                        Toast.makeText(getApplicationContext(), "problem image", Toast.LENGTH_SHORT).show();
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<ServerResponse> call, Throwable t) {
//                    hidepDialog();
//                    Log.v("Response gotten is", t.getMessage());
//                    Toast.makeText(getApplicationContext(), "problem uploading image " + t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                }
//            });
//        }
//    }

    private void launchPicker() {
        new MaterialFilePicker()
                .withActivity(this)
                .withRequestCode(FILE_PICKER_REQUEST_CODE)
                .withHiddenFiles(true)
                .withFilter(Pattern.compile(".*\\.pdf$"))
                .withTitle("Select PDF file")
                .start();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FILE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            String path = data.getStringExtra(FilePickerActivity.RESULT_FILE_PATH);
            File file = new File(path);
            displayFromFile(file);
            if (path != null) {
                Log.d("Path: ", path);
                pdfPath = path;
                Toast.makeText(this, "Picked file: " + path, Toast.LENGTH_LONG).show();
            }
        }

    }

    private void displayFromFile(File file) {
        Uri uri = Uri.fromFile(new File(file.getAbsolutePath()));
        pdfFileName = getFileName(uri);

        pdfView.fromFile(file)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .onPageError(this)
                .load();
    }

    private String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        if (result == null) {
            result = uri.getLastPathSegment();
        }
        return result;
    }

    @Override
    public void loadComplete(int nbPages) {
        PdfDocument.Meta meta = pdfView.getDocumentMeta();


    }



    private void initDialog() {
    }

    @Override
    public void onClick(View v) {
        if (v == proceedNineBtn){
            Intent intent =  new Intent(this, DeclarationActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfFileName, page + 1, pageCount));
    }

    @Override
    public void onPageError(int page, Throwable t) {

    }
}
