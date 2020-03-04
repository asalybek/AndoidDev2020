package com.example.firstprojectjob;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {
    private List<Post> posts;
    private IChange mChangeListener;
    private IDislike mDisLikeListener;

    public PostAdapter (List<Post> posts,IDislike mDisLikeListener){
        this.posts = posts;
        this.mDisLikeListener= mDisLikeListener;
    }
    public PostAdapter (List<Post> posts,IChange mChangeListener){
        this.posts = posts;
        this.mChangeListener= mChangeListener;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.post_row,parent,false);
        return new PostHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PostHolder holder, int position) {
        final Post post = posts.get(position);
        holder.name.setText(post.getName());
        holder.login.setText(post.getLogin());
        holder.date.setText(post.getDate());
        holder.post.setText(post.getPost());
        holder.commentCnt.setText(post.getCommentCnt());
        holder.tweetCnt.setText(post.getTweetCnt());
        holder.likeCnt.setText(String.valueOf(post.getLikeCnt()));
        holder.profileImg.setImageResource(post.getProfileImg());
        holder.like.setImageResource(post.getRedlike());

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!post.isLiked()) {
                    holder.like.setImageResource(R.drawable.ic_like_clicked_row);
                    int s = Integer.parseInt(holder.likeCnt.getText().toString())+1;
                    holder.likeCnt.setText(String.valueOf(s));
                    post.setLiked(true);
                    post.setRedlike(R.drawable.ic_like_clicked_row);
                    post.setLikeCnt(post.getLikeCnt() + 1 );
                    if (mChangeListener != null) {
                        mChangeListener.onPostLike();}
                    if (mDisLikeListener != null) {
                        mDisLikeListener.onPostDisLike();
                    }
                }
                else {
                    holder.like.setImageResource(R.drawable.ic_heart_row);
                    int s = Integer.parseInt(holder.likeCnt.getText().toString()) - 1;
                    holder.likeCnt.setText(String.valueOf(s));
                    post.setLiked(false);
                    post.setLikeCnt(post.getLikeCnt() - 1);
                    post.setRedlike(R.drawable.ic_heart_row);
                    if (mChangeListener != null) {
                        mChangeListener.onPostLike();
                    }
                    if (mDisLikeListener != null) {
                        mDisLikeListener.onPostDisLike();
                    }
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder {

        private TextView name,login,date,post,commentCnt,tweetCnt,likeCnt;
        private ImageView profileImg;
        private ImageButton like;

        private PostHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_txt);
            login = itemView.findViewById(R.id.login_txt);
            date = itemView.findViewById(R.id.date);
            post = itemView.findViewById(R.id.post_txt);
            commentCnt = itemView.findViewById(R.id.comments_cnt);
            tweetCnt = itemView.findViewById(R.id.reTweet_cnt);
            likeCnt = itemView.findViewById(R.id.likes_cnt);
            profileImg = itemView.findViewById(R.id.profile_img);
            like = itemView.findViewById(R.id.ic_like);
        }
    }
}
