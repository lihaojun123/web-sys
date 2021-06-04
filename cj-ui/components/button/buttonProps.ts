import { PropType } from "vue";
enum ButtonType {
  'default', 'primary', 'ghost', 'dashed', 'danger', 'link'
}
enum ButtonSize {
  'large', 'default', 'small'
}
enum ButtonShape {
  'circle', 'circle-outline', 'round'
}
const buttonProps = {
  prefixCls: String as PropType<String>,
  type: ButtonType,
  shape: ButtonShape,
  size: ButtonSize,
  loading: Boolean as PropType<Boolean>,
  disabled: Boolean as PropType<Boolean>,
}