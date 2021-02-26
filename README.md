# shophelpdemo

```
购物助手集成文档
功能介绍
购物助手 监听淘宝，京东详情页商品信息来取相应的商品购物卷
监听美团外卖，美团，饿了么 app获取美食优惠卷

准备工作
1.将 compileSdkVersion ，buildToolsVersion和 targetSdkVersion对应的版本号改为30以下（因为 setGravity shouldn't be called on text toasts the values won't be used在30以上版本已经被不能用。详情https://developer.android.com/reference/android/widget/Toast#setGravity(int,%20int,%20int) 请开发者放心集成）

例如：

compileSdkVersion 29
buildToolsVersion "29.0.3"
defaultConfig {
     ...
        targetSdkVersion 29
        ...
    }

2.在项目下build.gradle中添加

allprojects {
    repositories {
      ...
        maven { url "https://raw.githubusercontent.com/Pgyer/helpshop/master" }
    }
}

3.在app/build.gradle中添加

dependencies {
 ...
  implementation 'com.pgyer:helpshop:1.1.1'
}

4.在 application 中集成

...
import com.pgyer.help_shop_library.ShopHelpManager;
​
public class {当前应用的application} extends Application {
​
    @Override
    public void onCreate() {
        super.onCreate();
        new ShopHelpManager.InitSdk().setContext(this).build();
    }
}


4.在 AndroidManifest.xml 注意修改 android:name="{当前应用的application}"此处的名字对应上面继承 Application 的类名 ,添加ZK_HM_KEY ，添加是否添加检查更新的开关

<application
        android:name=".{当前应用的application}"
        android:allowBackup="true"
        android:networkSecurityConfig="@xml/network"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
          ...
        <meta-dataandroid:name="APP_KEY"  android:value="{从服务商获取的appkey}" />
          ...                
  </application>

调用介绍
1.判断当前是否打开辅助模式（无障碍），true表示已经打开，false表示为打开

ShopHelpManager.isOpenAccessiblity(Activity activity)

2 去打开辅助模式
a.带参数回到当前activity
ShopHelpManager.startAccessiblityForResult(Activity activity,int requestCode)

b.不带参数回到当前activity
ShopHelpManager.startAccessiblity（Activity activity）
```
