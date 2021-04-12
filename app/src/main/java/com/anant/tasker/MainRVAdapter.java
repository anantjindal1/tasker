package com.anant.tasker;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.anant.tasker.models.Task;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MainRVAdapter extends RecyclerView.Adapter<MainRVAdapter.ViewHolder> {

   // private String[] localDataSet;
    private List<Task> tasks;
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvTitle,tvProject,tvGroup,tvDetails,tvPriority;
        public View hiddenView;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            tvTitle = view.findViewById(R.id.taskName);
            tvProject = view.findViewById(R.id.taskProject);
            tvGroup = view.findViewById(R.id.taskGroup);
            tvDetails = view.findViewById(R.id.taskDetails);
            tvPriority = view.findViewById(R.id.taskPriority);
            hiddenView = view.findViewById(R.id.hiddenLayout);

            //textView = (TextView) view.findViewById(R.id.taskName);
        }

     //   public TextView getTextView() {
            //return textView;
      //  }
    }

    int mExpandedPosition = -1;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public MainRVAdapter(List<Task> dataSet) {
        tasks = dataSet;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        Task task = tasks.get(position);
        viewHolder.tvTitle.setText(task.title);
        viewHolder.tvProject.setText(task.Project_id);
        viewHolder.tvGroup.setText(task.board_id);
//        viewHolder.tvPriority.setText(task.priority);
        viewHolder.tvDetails.setText(task.description);

        final boolean isExpanded = position==mExpandedPosition;
        viewHolder.hiddenView.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        //viewHolder.itemView.setActivated(isExpanded);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                notifyDataSetChanged();
            }
        });

        viewHolder.hiddenView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"clicked here",Toast.LENGTH_SHORT).show();

                //open task editing activity here
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
