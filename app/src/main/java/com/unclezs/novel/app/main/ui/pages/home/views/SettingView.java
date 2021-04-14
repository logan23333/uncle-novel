package com.unclezs.novel.app.main.ui.pages.home.views;

import com.unclezs.novel.app.framework.annotation.FxView;
import com.unclezs.novel.app.framework.components.sidebar.NavigateBundle;
import com.unclezs.novel.app.framework.components.sidebar.SidebarView;
import javafx.scene.layout.StackPane;
import lombok.extern.slf4j.Slf4j;

/**
 * @author blog.unclezs.com
 * @since 2021/03/05 17:26
 */
@Slf4j
@FxView(fxml = "/layout/home/views/setting/setting.fxml")
public class SettingView extends SidebarView<StackPane> {

  @Override
  public void onCreated() {
  }

  @Override
  public void onShow(NavigateBundle bundle) {
    System.out.println(bundle.getData());
//    ThreadUtil.execute(() -> {
//      ThreadUtil.sleep(1000);
//      if (App.manifest != null && App.manifest.isNewVersion()) {
//        FxUtils.runFx(() -> {
//          JFXAlert<String> alert = new JFXAlert<>(App.app.getStage());
//          alert.initModality(Modality.APPLICATION_MODAL);
//          JFXDialogLayout layout = new JFXDialogLayout();
//          StringBuilder sb = new StringBuilder();
//          for (String s : App.manifest.getChangeLog()) {
//            sb.append(s).append("\n");
//          }
//          layout.setBody(new Label(sb.toString()));
//          alert.setContent(layout);
//          alert.show();
//        });
//      }
//    });
  }
}
