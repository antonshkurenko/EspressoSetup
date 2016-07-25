package io.github.tonyshkurenko.testsetup.recyclerviewclick;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import io.github.tonyshkurenko.testsetup.R;

public class RecyclerViewActivity extends AppCompatActivity {

  String[] mStringArray;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_recycler_view);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    mStringArray = getResources().getStringArray(R.array.dummy_data);

    final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new DummyAdapter(mStringArray));
  }

  static final class DummyAdapter extends RecyclerView.Adapter<DummyAdapter.DummyHolder> {

    Context mContext;

    final String[] mData;

    public DummyAdapter(String[] data) {
      mData = data;
    }

    @Override public void onAttachedToRecyclerView(RecyclerView recyclerView) {
      super.onAttachedToRecyclerView(recyclerView);

      mContext = recyclerView.getContext();
    }

    @Override public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
      super.onDetachedFromRecyclerView(recyclerView);

      mContext = null;
    }

    @Override public DummyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      return new DummyHolder(LayoutInflater.from(mContext)
          .inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override public void onBindViewHolder(DummyHolder holder, int position) {
      holder.bind(mData[position]);
    }

    @Override public int getItemCount() {
      return mData.length;
    }

    static class DummyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

      TextView mTextView;

      private String mText;

      public DummyHolder(View itemView) {
        super(itemView);

        mTextView = (TextView) itemView.findViewById(android.R.id.text1);
      }

      void bind(String data) {

        mText = data;

        mTextView.setText(mText);

        itemView.setOnClickListener(this);
      }

      @Override public void onClick(View view) {
        Toast.makeText(view.getContext(), mText, Toast.LENGTH_LONG).show();
      }
    }
  }
}
