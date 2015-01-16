package cbedoy.circularloader;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Carlos Bedoy on 1/16/15.
 * <p/>
 * Mobile App Developer - Bills Android
 * <p/>
 * Pademobile
 */
public class LoaderDialogView extends AbstractDialog
{
    private ImageView mLoaderImage;
    private TextView mLoaderText;
    private CBCircularProgressBar mCircularProgressBar;
    private ObjectAnimator mProgressBarAnimator;
    private String mTextLoader;
    private int mIconResource;
    private Color mProgressColor;
    private Color mProgressBackgroundColor;

    public LoaderDialogView(Activity activity) {
        super(activity);
    }

    @Override
    public View init()
    {
        this.view = ApplicationLoader.mMainLayoutInflater.inflate(R.layout.loader_view, null);
        this.mLoaderImage = (ImageView)view.findViewById(R.id.notification_view_icon);
        this.mLoaderText = (TextView)view.findViewById(R.id.txtLoading);
        this.mCircularProgressBar = (CBCircularProgressBar)view.findViewById(R.id.notification_view_circle_dialog);
        this.mCircularProgressBar.setWheelSize(12);
        this.mCircularProgressBar.setProgressColor(Color.parseColor("#00796B"));
        this.mCircularProgressBar.setProgressBackgroundColor(Color.parseColor("#004D40"));
        if (this.mProgressBarAnimator != null) {
            this.mProgressBarAnimator.cancel();
        }
        animate(this.mCircularProgressBar, null, 1f, 1500);
        return view;
    }

    private void animate(final CBCircularProgressBar progressBar, final Animator.AnimatorListener listener, final float progress, final int duration) {

        this.mProgressBarAnimator = ObjectAnimator.ofFloat(progressBar, "progress", progress);
        this.mProgressBarAnimator.setDuration(duration);

        this.mProgressBarAnimator.addListener(new Animator.AnimatorListener() {

            @Override
            public void onAnimationCancel(final Animator animation) {
            }

            @Override
            public void onAnimationEnd(final Animator animation) {
                progressBar.setProgress(progress);
                progressBar.setProgress(0f);
            }

            @Override
            public void onAnimationRepeat(final Animator animation) {
            }

            @Override
            public void onAnimationStart(final Animator animation) {
            }
        });
        if (listener != null) {
            this.mProgressBarAnimator.addListener(listener);
        }
        this.mProgressBarAnimator.reverse();
        this.mProgressBarAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(final ValueAnimator animation) {
                progressBar.setProgress((Float) animation.getAnimatedValue());
            }
        });
        this.mProgressBarAnimator.setRepeatCount(ValueAnimator.INFINITE);
        this.mProgressBarAnimator.start();


    }
    @Override
    public void reload() {

    }


    public void setIconResource(int mIconResource) {
        this.mIconResource = mIconResource;
    }

    public void setProgressBackgroundColor(Color mProgressBackgroundColor) {
        this.mProgressBackgroundColor = mProgressBackgroundColor;
    }

    public void setProgressColor(Color mProgressColor) {
        this.mProgressColor = mProgressColor;
    }

    public void setTextLoader(String mTextLoader) {
        this.mTextLoader = mTextLoader;
    }
}
