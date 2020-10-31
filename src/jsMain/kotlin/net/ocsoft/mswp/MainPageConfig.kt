package net.ocsoft.mswp
import net.ocsoft.mswp.ui.GridSettings
import net.ocsoft.mswp.ui.AppSettings
import net.ocsoft.mswp.ui.IconSelector
import net.ocsoft.mswp.ui.ColorSelector
import net.ocsoft.mswp.ui.PointLightSetting
import net.ocsoft.mswp.ui.IconSetting
import net.ocsoft.mswp.ui.GameSettings
import net.ocsoft.mswp.ui.Flag

/**
 * main page configuration
 */
data class MainPageConfig(
    /** game grid settings */
    val gridSettings : GridSettings = GridSettings("#game_grid", 
            "#glyph_workarea",
            "#game_over_modal",
            "#player_won_modal",
            "#back-to-main",
            ".setting.menu .menu.item",
            IconSetting()),
    /** splash pane */
    val splashPaneId : String = "#splash_pane",
    /** application settings */
    val appSettings : AppSettings.Option = AppSettings.Option(
        GameSettings.Option(
            GameSettings.Option.Queries(
                ".setting.menu .menu.item", 
                ".setting.menu.contents",
                "#label-setting",
                "#color-setting",
                "#lighting-setting")),
        Environment.Option(
            "#game_grid",
            "body" ,
            ".setting.menu",
            ".menu-bar .flags .flag-icon", 
            arrayOf(".menu-bar .flags .flag-icon",
                ".menu-bar .flags .flag-count"),
            "color-to-transparent-1",
            "#back-to-main svg"),
        IconSelector.Option("#icon_list",
            "#icon_list .icons", 
            "#icon_list .icons li",
            "#icon_list .pagination.container",
            "#icon_list .ok",
            "#icon-kind-selector",
            "svg.svg-inline--fa",
            "#icon_item_tmpl",
            "#blank_icon_item_tmpl",
            "#icons_paginating_full_tmpl",
            "#icons_paginating_middle_tmpl",
            "#icons_paginating_simple_tmpl",
            "#icons_paginating_item_tmpl",
            "#synchronizing-icon",
            gridSettings.iconSetting),
        ColorSelector.Option(
            "#color-selector",
            "#color-selector .oc-color-circle",
            "#color-selector .ok",
            "#color-selector .initial-setting",
            ".colors.container",
            ".color-item-0",
            ".color-item-1",
            ".color-item-3",
            ".color-item-4",
            ".color-item-env-0",
            ".color-item-env-1",
            "color-scheme",
            ".description",
            "#synchronizing-icon"),
        PointLightSetting.Option("#synchronizing-icon-2"),
        Flag.Option(".menu-bar .flags",
            ".flag-icon",
            ".flag-count",
            "blink-color"))) {
}

// vi: se ts=4 sw=4 et: 
