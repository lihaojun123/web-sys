const childDemo = {
  name: 'ChildDemo',
  data() {
    return {
      title: '这是一个标题',
      list: ['a', 'b', 'c']
    }
  },
  props: {
    message: String
  },
  methods: {
    myclick() {
      console.log('点击了事件')
    },
    getElement(list) {
      return (
        <div>
          {list.map(item => {
            <li>{item}</li>
          })}
        </div>
      )
    }
  },
  render() {
    return (
      <div>
        <p>我是jsx作用域插槽标题</p>
        {this.$scopedSlots.default(this.list)}
      </div>
    )
  }
}
export default {
  data() {
    return {
      message: 'hello world'
    }
  },
  methods: {
  },
  mounted() {
  },
  render() {
    return (
      <childDemo message={this.message}
        scopedSlots={{
          default: (props) => {
            console.log(props)
            return (
              <div>
                {props.map(item => {
                  return <p>{item}</p>
                })}
              </div>
            )
          }
        }}></childDemo>
    )
  }
}