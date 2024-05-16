package dev.aaa1115910.biliapi.http.entity.user

import dev.aaa1115910.biliapi.http.entity.video.VideoStat
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonElement

/**
 * 空间投稿视频
 *
 * @param archives 列表信息
 * @param page 页面信息
 */
@Serializable
data class WebSpaceVideoData(
    val archives: List<VListItem>? = null,
    val page: Page? = null,
) {
    @Serializable
    data class VListItem(
        val aid: Long,
        val bvid: String,
        val pic: String,
        val title: String,
        val duration: Int,
        val pubdate: Long,
        @SerialName("enable_vt")
        val enableVt: Int,
        @SerialName("vt_display")
        val vtDisplay: String,
        val author: Author,
        val stat: Stat,
    ) {
        @Serializable
        data class Author(
            val mid: Long,
            val name: String,
            val face: String,
        )
        @Serializable
        data class Stat (
            val view: Int,
            val danmaku: Int,
            val reply: Int,
            val favorite: Int,
            val coin: Int,
            val share: Int,
            val like: Int,
            val vt: Long,
        )
    }
    /**
     * @param pageNumber 当前页码
     * @param pageSize 每页项数
     * @param count 总计稿件数
     */
    @Serializable
    data class Page(
        @SerialName("pn")
        val pageNumber: Int,
        @SerialName("ps")
        val pageSize: Int,
        val count: Int,
    )

}

/**
 * 空间投稿视频（App）
 *
 * @param episodicButton “播放全部“按钮
 * @param order 排序方式
 * @param count 视频总数
 */
@Serializable
data class AppSpaceVideoData(
    @SerialName("episodic_button")
    val episodicButton: EpisodicButton? = null,
    val order: List<Order> = emptyList(),
    val count: Int,
    val item: List<SpaceVideoItem> = emptyList(),
    @SerialName("last_watched_locator")
    val lastWatchedLocator: LastWatchedLocator,
    @SerialName("has_next")
    val hasNext: Boolean,
    val hasPre: Boolean = false
) {
    /**
     * 排序方式
     *
     * @param title 排序方式名称 最新发布/最多播放
     * @param value 排序方式值 pubdate/click
     */
    @Serializable
    data class Order(
        val title: String,
        val value: String
    )

    @Serializable
    data class SpaceVideoItem(
        val title: String,
        val subtitle: String,
        val tname: String,
        val cover: String,
        val uri: String,
        val param: String,
        val goto: String,
        val length: String,
        val duration: Int,
        @SerialName("is_popular")
        val isPopular: Boolean,
        @SerialName("is_steins")
        val isSteins: Boolean,
        @SerialName("is_ugcpay")
        val isUgcpay: Boolean,
        @SerialName("is_cooperation")
        val isCooperation: Boolean,
        @SerialName("is_pgc")
        val isPgc: Boolean,
        @SerialName("is_live_playback")
        val isLivePlayback: Boolean,
        val play: Int,
        val danmaku: Int,
        val ctime: Int,
        @SerialName("ugc_pay")
        val ugcPay: Int,
        val author: String,
        val state: Boolean,
        val bvid: String,
        val videos: Int,
        @SerialName("three_point")
        val threePoint: List<ThreePointItem> = emptyList(),
        @SerialName("first_cid")
        val firstcid: Long,
        @SerialName("cursor_attr")
        val cursorAttr: CursorAttr,
        @SerialName("icon_type")
        val iconType: Int
    ) {
        @Serializable
        data class ThreePointItem(
            val type: String,
            val icon: String,
            val text: String,
            @SerialName("share_succ_toast")
            val shareSuccToast: String? = null,
            @SerialName("share_fail_toast")
            val shareFailToast: String? = null,
            @SerialName("share_path")
            val sharePath: String? = null,
            @SerialName("short_link")
            val shortLink: String? = null,
            @SerialName("share_subtitle")
            val shareSubtitle: String? = null
        )

        @Serializable
        data class CursorAttr(
            @SerialName("is_last_watched_arc")
            val isLastWatchedArc: Boolean,
            val rank: Int
        )
    }

    @Serializable
    data class LastWatchedLocator(
        @SerialName("display_threshold")
        val displayThreshold: Int,
        @SerialName("insert_ranking")
        val insertRanking: Int,
        val text: String
    )
}

/**
 * 全部播放按钮
 *
 * @param text 按钮文字
 * @param uri 全部播放页url
 */
@Serializable
data class EpisodicButton(
    val text: String,
    val uri: String
)