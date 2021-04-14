package com.unclezs.novel.app.framework.view;

import com.unclezs.novel.app.framework.i18n.LocalizedSupport;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import lombok.Getter;
import lombok.Setter;

/**
 * @param <V> 视图类型
 * @author blog.unclezs.com
 * @date 2021/4/12 9:52
 */
@Getter
@Setter
public class View<V> implements Initializable, LocalizedSupport {

  /**
   * 国际化资源包
   */
  protected ResourceBundle bundle;
  /**
   * 控制器对应的视图
   */
  protected V root;

  /**
   * view创建之后，还没有做fx的初始化
   */
  public void onCreate() {
    // Bean创建完成
  }

  /**
   * view被销毁时调用
   */
  public void onDestroy() {
    // 一般为程序退出保持数据
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    this.bundle = resources;
    onCreate();
  }
}
