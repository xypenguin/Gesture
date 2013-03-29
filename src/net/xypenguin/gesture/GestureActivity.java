package net.xypenguin.gesture;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class GestureActivity extends Activity implements OnGestureListener {
	private TextView textView;
	private GestureDetector detector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture);
		// コンポーネントの関連付け
		textView = (TextView) this.findViewById(R.id.textView01);
		// ジェスチャーディテクターの生成
		detector = new GestureDetector(this, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_gesture, menu);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		// タッチの座標をパディングに入れて、テキスト表示
		String s = "X:" + event.getX() + ",Y:" + event.getY();
		textView.setPadding((int) event.getX(), (int) event.getY() - 200, 0, 0);
		textView.setVisibility(View.VISIBLE);

		// フリックやロングプレスなど複雑な動作をさせるときは、ジェスチャーディテクターにイベントを渡す
		detector.onTouchEvent(event);

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			Log.v("TouchEvent", "ACTION_DOWN " + "X:" + event.getX() + ",Y:"
					+ event.getY());
			break;
		// 指を離したときのイベント　テキストを非表示
		case MotionEvent.ACTION_UP:
			Log.v("TouchEvent", "ACTION_UP " + "X:" + event.getX() + ",Y:"
					+ event.getY());
			textView.setVisibility(View.GONE);
			break;
		case MotionEvent.ACTION_MOVE:
			Log.v("TouchEvent", "ACTION_MOVE " + "X:" + event.getX() + ",Y:"
					+ event.getY());
			break;
		case MotionEvent.ACTION_CANCEL:
			Log.v("TouchEvent", "ACTION_CANCEL " + "X:" + event.getX() + ",Y:"
					+ event.getY());
			break;
		default:
			Log.w("TouchEvent", "default");
			break;
		}
		textView.setText(s);
		return true;
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("onDown", "ok");
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("onFling", "ok");
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("onLongPress", "ok");
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("onLongPress", "ok");
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("onShowPress", "ok");
	}

	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		Log.v("onSingleTapUp", "ok");
		return false;
	}

}
