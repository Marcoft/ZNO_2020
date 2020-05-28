package learn.zno.znostudy.TotalStats;

import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;
import learn.zno.znostudy.R;
import learn.zno.znostudy.TotalStats.DateDb.DateDbStats;
import learn.zno.znostudy.TotalStats.Recycler.ExampleAdapterStats;
import learn.zno.znostudy.TotalStats.Recycler.ExampleItemStats;
import learn.zno.znostudy.TotalStats.StatsDb.DateDbTotalStats;
import learn.zno.znostudy.db.DBHelpers;


public class ChoiseTotalStats extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    RecyclerView recyclerView;

    private ArrayList<ExampleItemStats> mExampleList;

    Spinner spinner;
    SearchView searchViewMain;

    private ExampleAdapterStats mAdapter;
    private LinearLayoutManager mLayoutManager;

    List<String> idText = new ArrayList<>();
    List<String> typeTest = new ArrayList<>();
    List<String> statsTest= new ArrayList<>();
    List<String> dateTest= new ArrayList<>();

    DBHelpers dbHelpers;

    String notChangedPosition = "";

    //String StartSpinnerPosition = "Сортування за назвою (спадання)";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choise_total_stats);

        recyclerView = findViewById(R.id.recyclerView);
        spinner = findViewById(R.id.spinner);
        searchViewMain = findViewById(R.id.searchViewMain);

        dbHelpers = new DBHelpers(this);

        mExampleList = new ArrayList<ExampleItemStats>();

        idText.clear();
        typeTest.clear();
        statsTest.clear();
        dateTest.clear();
        List<DateDbTotalStats> listDateDbStats = dbHelpers.getAllTotalStats();

        for(int i = 0; i < listDateDbStats.size(); i ++){
            idText.add(listDateDbStats.get(i).getIdText());
            typeTest.add(listDateDbStats.get(i).getTypeTest());
            statsTest.add(listDateDbStats.get(i).getStatsTest());
            dateTest.add(listDateDbStats.get(i).getDateTest());
        }

        if(idText.size() > 0) {
            for (int i = 0; i < idText.size(); i++) {
                mExampleList.add(new ExampleItemStats(idText.get(i), typeTest.get(i), statsTest.get(i), dateTest.get(i)));
            }
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mLayoutManager.setReverseLayout(true);
            mLayoutManager.setStackFromEnd(true);
            mAdapter = new ExampleAdapterStats(mExampleList);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(mAdapter);
            mAdapter.setOnItemClickListener(new ExampleAdapterStats.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    notChangedPosition = mExampleList.get(position).getIdText();
                    Intent intent = new Intent(getApplicationContext(), TotalStat.class);
                    intent.putExtra("position", notChangedPosition);
                    startActivity(intent);
                }
            });
            ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
            itemTouchHelper.attachToRecyclerView(recyclerView);

            searchView();
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.sortSpinner,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    //SearchView
    private void searchView(){
        searchViewMain.setImeOptions(EditorInfo.IME_ACTION_DONE);

        searchViewMain.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                spinner.setSelection(0);
                mAdapter.getFilter().filter(newText);

                if (!searchViewMain.getQuery().toString().equalsIgnoreCase("")) {
                    spinner.setVisibility(View.GONE);
                } else{
                    spinner.setVisibility(View.VISIBLE);
                }


                return false;
            }
        });
    }

    //Spinner selected
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
        List<DateDbTotalStats> listDateDbStatsAndSort = null;
        if(idText.size() > 0) {
            String text = adapterView.getItemAtPosition(position).toString();
            switch (text) {
                case "Сортування за назвою (спадання)":
                    //StartSpinnerPosition = "Сортування за назвою (спадання)";
                    listDateDbStatsAndSort = dbHelpers.getAllTotalStatsAndSort("idText ASC");
                    newListAfterSorted(listDateDbStatsAndSort);
                    break;
                case "Сортування за назвою (зростання)":
                    //StartSpinnerPosition = "Сортування за назвою (зростання)";
                    listDateDbStatsAndSort = dbHelpers.getAllTotalStatsAndSort("idText DESC");
                    newListAfterSorted(listDateDbStatsAndSort);
                    break;
                case "Сортування за типом (спочатку ЗНО)":
                    //StartSpinnerPosition = "Сортування за типом (спочатку ЗНО)";
                    listDateDbStatsAndSort = dbHelpers.getAllTotalStatsAndSort("typeTest DESC");
                    newListAfterSorted(listDateDbStatsAndSort);
                    break;
                case "Сортування за типом (спочатку Тести)":
                    //StartSpinnerPosition = "Сортування за типом (спочатку Тести)";
                    listDateDbStatsAndSort = dbHelpers.getAllTotalStatsAndSort("typeTest ASC");
                    newListAfterSorted(listDateDbStatsAndSort);
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void newListAfterSorted(List<DateDbTotalStats> listDateDbStatsAndSort){
        if (listDateDbStatsAndSort != null) {
            idText.clear();
            typeTest.clear();
            statsTest.clear();
            dateTest.clear();
            mExampleList.clear();

            for(int i = 0; i < listDateDbStatsAndSort.size(); i ++){
                idText.add(listDateDbStatsAndSort.get(i).getIdText());
                typeTest.add(listDateDbStatsAndSort.get(i).getTypeTest());
                statsTest.add(listDateDbStatsAndSort.get(i).getStatsTest());
                dateTest.add(listDateDbStatsAndSort.get(i).getDateTest());
            }
            for (int i = 0; i < idText.size(); i++) {
                mExampleList.add(new ExampleItemStats(idText.get(i), typeTest.get(i), statsTest.get(i), dateTest.get(i)));
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    //Swipe element
    ExampleItemStats deletedMovie = null;
    List<ExampleItemStats> archivedMovies = new ArrayList<ExampleItemStats>();

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, /*ItemTouchHelper.LEFT | */ ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {

            final int position = viewHolder.getAdapterPosition();

            switch (direction) {
                case ItemTouchHelper.RIGHT:
                    deletedMovie = mExampleList.get(position);
                    deleteDateFromDb(position);
                    mExampleList.remove(position);
                    mAdapter.notifyItemRemoved(position);

                    final Snackbar snackbar = Snackbar.make(recyclerView, deletedMovie.getIdText() + ", Видалено.", Snackbar.LENGTH_LONG);
                    snackbar.setAction("Скасувати", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    mExampleList.add(position, deletedMovie);
                                    mAdapter.notifyItemInserted(position);

                                    returnDateInBd(position);
                                }
                            }).show();

                    break;
                    /*
                case ItemTouchHelper.LEFT:
                    final ExampleItemStats movieName = mExampleList.get(position);
                    archivedMovies.add(movieName);

                    mExampleList.remove(position);
                    mAdapter.notifyItemRemoved(position);

                    Snackbar.make(recyclerView, movieName.getIdText() + ", Заархівовано.", Snackbar.LENGTH_LONG)
                            .setAction("Скасувати", new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    archivedMovies.remove(archivedMovies.lastIndexOf(movieName));
                                    mExampleList.add(position, movieName);
                                    mAdapter.notifyItemInserted(position);
                                }
                            }).show();

                    break;*/
            }
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

            new RecyclerViewSwipeDecorator.Builder(ChoiseTotalStats.this, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(ChoiseTotalStats.this, R.color.colorAccent))
                    .addSwipeRightActionIcon(R.drawable.ic_delete_black_24dp)
                    //.addSwipeLeftBackgroundColor(ContextCompat.getColor(ChoiseTotalStats.this, R.color.colorPrimaryDark))
                    //.addSwipeLeftActionIcon(R.drawable.ic_archive_black_24dp)
                    .setActionIconTint(ContextCompat.getColor(recyclerView.getContext(), android.R.color.white))
                    .create()
                    .decorate();

            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }

    };


    // Delete and Return date
    DateDbTotalStats savedDteDbTotalStats = null;
    String id = "", type = "", stats = "", date = "";
    int countAnswer = 0, startSize = 0, endSize = 0;

    DateDbStats saveDateDbStats = null;
    List<Integer> idSave = new ArrayList<>();
    List<String> resultSave = new ArrayList<>();
    List<String> questionSave= new ArrayList<>();
    List<String> rightSave = new ArrayList<>();

    private void deleteDateFromDb(int position){
        String PositionDontChange = "";
        idSave.clear();
        resultSave.clear();
        questionSave.clear();
        rightSave.clear();

        PositionDontChange = mExampleList.get(position).getIdText();

        savedDteDbTotalStats = dbHelpers.getDateTotalStats(PositionDontChange);
        id = savedDteDbTotalStats.getIdText();
        type = savedDteDbTotalStats.getTypeTest();
        stats = savedDteDbTotalStats.getStatsTest();
        date = savedDteDbTotalStats.getDateTest();
        countAnswer = savedDteDbTotalStats.getCountAnswers();
        startSize = savedDteDbTotalStats.getStartSize();
        endSize = savedDteDbTotalStats.getEndSize();

        for (int i = startSize; i < endSize; i++) {
            saveDateDbStats = dbHelpers.getDateFromStats(i);
            idSave.add(saveDateDbStats.getId());
            resultSave.add(saveDateDbStats.getYourAnswer());
            questionSave.add(saveDateDbStats.getQuestion());
            rightSave.add(saveDateDbStats.getRightAnswer());
        }

        dbHelpers.deleteDateTotalStats(PositionDontChange);
        for (int i = startSize; i < endSize;i ++){
            dbHelpers.deleteDateFromStats(i);
        }
    }

    private void returnDateInBd(int position){
        for (int i = 0; i < endSize - startSize;i ++){
            dbHelpers.addDataInStats(new DateDbStats(idSave.get(i), questionSave.get(i),resultSave.get(i), rightSave.get(i)));
        }
        dbHelpers.addDataTotalStats(new DateDbTotalStats(id,type,stats,date,countAnswer,startSize,endSize));
    }

    public void finish(View view) {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbHelpers.close();
    }
}
