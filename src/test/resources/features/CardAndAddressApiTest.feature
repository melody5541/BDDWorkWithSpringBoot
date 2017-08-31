# language: zh-CN
@api
功能: 银行卡查询
  为了查询银行卡数据
  作为银行柜员
  小明需要能够根据卡号、分页、全量查询银行卡数据

  @tag1
  @tagn
  场景大纲: 根据卡号查询银行卡数据(卡存在)
    假如 卡号为<cardNum>的银行卡数据已经存在
    当 小明查询卡号为<cardNum>的银行卡数据
    那么 数据满足<cardSchemaFile>所要求的格式
    并且 小明获取到的卡号为<cardNum>的银行卡数据应有<cardCount>条

  @try
    例子: 信用卡(Credit Card)
      | cardNum  | cardSchemaFile   | cardCount |
      | C0000001 | card-schema.json | 1         |

    例子: 储蓄卡(Saving Card)
      | cardNum  | cardSchemaFile   | cardCount |
      | S0000003 | card-schema.json | 1         |


  场景大纲: 根据卡号查询银行卡数据(卡不存在)
    假如 卡号为<cardNum>的银行卡数据不存在
    当 小明查询卡号为<cardNum>的银行卡数据
    那么 数据满足<cardSchemaFile>所要求的格式
    并且 小明获取到的卡号为<cardNum>的银行卡数据应有<cardCount>条

    例子: 未知卡(UnKnown Card)
      | cardNum  | cardSchemaFile   | cardCount |
      | N0000000 | card-schema.json | 0         |
