package khan.zian.hasan.mymedium;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import khan.zian.hasan.mymedium.adaptor.UrlAdaptor;
import khan.zian.hasan.mymedium.viewModel.UrlViewModel;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.list)
    RecyclerView list;
    private UrlViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));

        final UrlAdaptor adaptor = new UrlAdaptor();
        list.setAdapter(adaptor);


        viewModel = ViewModelProviders.of(this).get(UrlViewModel.class);
        viewModel.getAllUrls().observe(this, adaptor::setList);
    }
}
