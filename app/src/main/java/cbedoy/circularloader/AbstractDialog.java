package cbedoy.circularloader;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Carlos Bedoy on 1/16/15.
 * <p/>
 * Mobile App Developer - Bills Android
 * <p/>
 * Pademobile
 */
public abstract class AbstractDialog
{
    protected Activity activity;
    protected View view;
    protected Dialog dialog;

    public AbstractDialog(Activity activity){
        this.activity = activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void show()
    {
        final AbstractDialog weakSelf = this;
        this.activity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                if(weakSelf.dialog == null)
                    weakSelf.createDialogView();
                weakSelf.takeCurrentScreamShot();
                weakSelf.reload();
                weakSelf.dialog.show();
            }
        });
    }

    public  void createDialogView()
    {
        this.dialog = new Dialog(this.activity);
        this.dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.dialog.setContentView(init());
        this.dialog.setCanceledOnTouchOutside(true);
        this.dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        //this.dialog.getWindow().setWindowAnimations(R.style.other_apps_animation);
    }

    public void hide()
    {
        final AbstractDialog weakSelf = this;
        this.activity.runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                if(weakSelf.dialog != null)
                    weakSelf.dialog.hide();
                System.gc();
            }
        });
    }



    protected void takeCurrentScreamShot()
    {
        Bitmap bitmap = ApplicationLoader.takeScreenShot(activity);
        Bitmap bitmap1 = BlurService.getInstance().performRequestBlurByImageWithRadius(bitmap, 10);
        Drawable drawable = new BitmapDrawable(bitmap1);
        this.dialog.getWindow().setBackgroundDrawable(drawable);
    }


    public void dealloc()
    {
        this.activity = null;
        this.dialog = null;
        this.view = null;
    }

    public abstract View init();
    public abstract void reload();

}
