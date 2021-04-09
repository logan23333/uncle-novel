package com.unclezs.novel.app.framework.components.sidebar;

import com.unclezs.novel.app.framework.collection.SimpleObservableList;
import com.unclezs.novel.app.framework.util.ViewUtils;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.DefaultProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import lombok.Getter;

/**
 * 侧边菜单导航栏
 *
 * @author blog.unclezs.com
 * @since 2021/02/26 18:50
 */
@DefaultProperty("menusGroups")
public class SidebarNavigation extends ScrollPane {

  private static final String DEFAULT_STYLE_CLASS = "sidebar-nav";
  private static final String DEFAULT_MENUS_STYLE_CLASS = "sidebar-nav-menus";
  @Getter
  private final VBox container = ViewUtils.addClass(new VBox(), DEFAULT_MENUS_STYLE_CLASS);
  @Getter
  private final List<SidebarNavigationMenu> menus = new ArrayList<>();
  /**
   * 菜单列表
   */
  @Getter
  private ObservableList<SidebarNavigationMenuGroup> menusGroups = new SimpleObservableList<>() {
    @Override
    public void onAdd(SidebarNavigationMenuGroup element) {
      addMenuGroup(element);
    }

    @Override
    public void onRemove(SidebarNavigationMenuGroup element) {
      removeMenuGroup(element);
    }
  };

//    new TrackableObservableList<>() {
//      @Override
//      protected void onChanged(ListChangeListener.Change<SidebarNavigationMenuGroup> c) {
//        while (c.next()) {
//          c.getRemoved().forEach(SidebarNavigation.this::removeMenuGroup);
//          c.getAddedSubList().forEach(SidebarNavigation.this::addMenuGroup);
//        }
//      }
//    };


  public SidebarNavigation() {
    this.getStyleClass().add(DEFAULT_STYLE_CLASS);
    this.setContent(container);
  }

  /**
   * 删除一组菜单
   *
   * @param sidebarNavigationMenuGroup 菜单组
   */
  public void removeMenuGroup(SidebarNavigationMenuGroup sidebarNavigationMenuGroup) {
    this.container.getChildren().removeAll(sidebarNavigationMenuGroup.getMenus());
    this.menus.removeAll(sidebarNavigationMenuGroup.getMenus());
    if (sidebarNavigationMenuGroup.getGroupLabel() != null) {
      this.container.getChildren().remove(sidebarNavigationMenuGroup.getGroupLabel());
    }
  }

  /**
   * 添加一组菜单
   *
   * @param group 菜单组
   */
  public void addMenuGroup(SidebarNavigationMenuGroup group) {
    if (group.getGroupLabel() != null) {
      this.container.getChildren().add(group.getGroupLabel());
    }
    // 给每个菜单设置事件监听
    group.getMenus().forEach(menuBtn -> {
      this.container.getChildren().add(menuBtn);
      this.menus.add(menuBtn);
    });
  }
}
