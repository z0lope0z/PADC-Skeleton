#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.shadow;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.SpinnerAdapter;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;
import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;
import com.xtremelabs.robolectric.shadows.ShadowActivity;

@Implements(SherlockActivity.class)
public class ShadowSherlockActivity extends ShadowActivity {
	
	@Implementation
	public ActionBar getSupportActionBar() {
		return new ActionBar() {
			
			@Override
			public void show() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTitle(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setTitle(CharSequence arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setSubtitle(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setSubtitle(CharSequence arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setSelectedNavigationItem(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setNavigationMode(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setLogo(Drawable arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setLogo(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setListNavigationCallbacks(SpinnerAdapter arg0,
					OnNavigationListener arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setIcon(Drawable arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setIcon(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayUseLogoEnabled(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayShowTitleEnabled(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayShowHomeEnabled(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayShowCustomEnabled(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayOptions(int arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayOptions(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setDisplayHomeAsUpEnabled(boolean arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCustomView(View arg0, LayoutParams arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCustomView(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setCustomView(View arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setBackgroundDrawable(Drawable arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void selectTab(Tab arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeTabAt(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeTab(Tab arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeOnMenuVisibilityListener(OnMenuVisibilityListener arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeAllTabs() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Tab newTab() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isShowing() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void hide() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public CharSequence getTitle() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getTabCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Tab getTabAt(int arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public CharSequence getSubtitle() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Tab getSelectedTab() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getSelectedNavigationIndex() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getNavigationMode() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getNavigationItemCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getHeight() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getDisplayOptions() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public View getCustomView() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void addTab(Tab arg0, int arg1, boolean arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addTab(Tab arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addTab(Tab arg0, boolean arg1) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addTab(Tab arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addOnMenuVisibilityListener(OnMenuVisibilityListener arg0) {
				// TODO Auto-generated method stub
				
			}
		};
	}
		
	@Implementation
	public void setContentView(int layoutResId) {
		super.setContentView(layoutResId);
	}
}