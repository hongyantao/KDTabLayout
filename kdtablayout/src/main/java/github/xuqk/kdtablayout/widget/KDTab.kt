package github.xuqk.kdtablayout.widget

import android.content.Context
import android.graphics.*
import android.view.View
import github.xuqk.kdtablayout.KDTabLayout

/**
 * Created By：XuQK
 * Created Date：2/21/20 1:18 PM
 * Creator Email：xuqiankun66@gmail.com
 * Description：
 */
abstract class KDTab(
    context: Context) : View(context) {

    protected val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    /**
     * 内容区域在父布局中的位置
     */
    val contentRect = Rect()

    // ------供用户自定义的属性 START
    /**
     * tab包含的badge，如果需要可以实现它
     */
    var badge: KDTabBadge? = null
    /**
     * 该tab在整个TabLayout中的宽度比例
     * 该参数只在KDTabLayout的tabMode为TAB_MODE_SPREAD或TAB_MODE_FLEXIBLE的非滚动模式下生效
     */
    var weight: Int = 1
    /**单位dp*/
    var horizontalPadding: Float = 0f
    // ------供用户自定义的属性 END

    /**
     * @param selectedFraction 该Tab被选中的比例，即滚动完成度
     * @param selectedInLeft 该Tab是否是从左边滚动到右边
     */
    abstract fun onScrolling(selectedFraction: Float, selectedInLeft: Boolean)

    /**
     * 重置为初始状态
     */
    abstract fun reset()

    /**
     * 设置为选中状态
     */
    abstract fun selectTab()

    /**
     * 计算内容尺寸
     */
    abstract fun computeContentBounds()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawContent(canvas)
        drawBadge(canvas)
    }

    protected open fun drawContent(canvas: Canvas) {
    }

    protected fun drawBadge(canvas: Canvas) {
        badge?.draw(canvas)
    }
}