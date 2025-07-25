# CHANGELOG

## 5.4

更新日志：

- [功能] 一键搜索漏洞支持按照 `high/medium/low` 级别切换展示 @4ra1n
- [功能] 一键搜索漏洞重构 `UI` 生成代码解除 `27` 个最大上限 @4ra1n
- [功能] 表达式搜索功能的线程池支持强行停止 @4ra1n
- [功能] 处理 `JAR` 时保留常见配置文件并允许打开 @4ra1n
- [BUG] 修复某些 `Spring` 注解报错问题 @4ra1n
- [优化] 漏洞链搜索加入进度条并使用新线程防止卡死 @4ra1n
- [优化] 优化左侧文件树对目录和文件的排序方式 @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（激进用户尝试使用）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 5.3

更新日志：

- [重要] 支持深度优先搜索算法自动分析漏洞链 @4ra1n
- [重要] 表达式搜索代码重构，用户体验提升，小幅性能优化 @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（激进用户尝试使用）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 5.2

处理了一些问题，支持加载 `class` 标准项目（存在 `META-INF` 的项目）

更新日志：

- [重要] 分析 `SPRING` 某些情况遇到错误无法继续 @Gosiu
- [功能] 字符串搜索支持包含搜索和精确搜索两种 @4ra1n
- [BUG] 加载 `class` 类型项目时无法正确处理类名问题 @4ra1n
- [BUG] 数据量过大时搜索会卡住，已添加等待进度条 @4ra1n
- [BUG] 解决首页 `ALL STRING` 卡死问题 @4ra1n
- [BUG] 统计文件大小没有考虑 `class` 文件 @4ra1n
- [优化] 分析遇到错误应该继续完成而不终止 @4ra1n
- [优化] 优化首页字符串展示功能提示和引导 @4ra1n
- [优化] 启动时输入字体大小弹框应该始终位于顶层 @4ra1n
- [优化] 搜索界面用户提示内容优化 @4ra1n
- [其他] 更完善的 `CI` 测试流程 @4ra1n
- [其他] 升级所有依赖到最新 @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Honey Baby (https://github.com/Gosiu)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（激进用户尝试使用）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 5.1

注意：该版本数据库结构有变动，无法兼容之前的数据库结构，请重新构建数据库

更新日志：

- [功能] 支持启动时配置全局的字体大小 @4ra1n
- [功能] 记录方法调用 `OPCODE` 等信息以供后续使用 @TianMing2018
- [功能] 支持分析依赖目录文件名得到 `Gadget` 信息 @4ra1n
- [BUG] `WEB` 模块导出 `JSON` 丢失了 `PATH` 信息 @4ra1n
- [BUG] 导入多个 `JAR` 应该区分每个 `CLASS` 来源 @TianMing2018
- [BUG] 修复 `Spring` 分析低 `Java` 版本报错 @Gosiu
- [BUG] 修复 `WAR` 包情况左侧文件树无法自动定位 @4ra1n
- [优化] `WEB` 导出模块优化 `CSV` 表格设计 @4ra1n
- [其他] 添加测试用例保证每次代码提交不影响正常功能 @4ra1n
- [其他] 更新各种依赖到最新版 @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Honey Baby (https://github.com/Gosiu)
- TianMing2018 (https://github.com/TianMing2018)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（激进用户尝试使用）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 5.0

注意：该版本数据库结构有变动，无法兼容之前的数据库结构，请重新构建数据库

更新日志：

- [重要] 启动时支持选择 `标准/快速` 两种方式生成数据库 @4ra1n
- [重要] 支持拖动 `GUI` 便于查看 @4ra1n
- [功能] 支持 `Spring Interceptor` 静态分析 @4ra1n
- [功能] 支持 `Serlvet/Filter/Listener` 静态分析 @4ra1n
- [功能] 支持导出 `Spring` 等信息为 `TXT/JSON/CSV` @4ra1n
- [功能] 全局 `LUCENE` 搜索支持大小写敏感选项 @Gosiu
- [功能] 一键搜索新增 `JDBC DriverManager` 相关 @4ra1n
- [功能] 字符串搜索允许输入指定类名 @4ra1n
- [功能] 表达式搜索内置多种常用场景语句以供参考 @4ra1n
- [功能] 表达式搜索父类子类相关语法支持跨多层 @4ra1n
- [功能] 表达式搜索支持 `isPublic` 语法 @4ra1n
- [功能] 表达式搜索支持 `nameNotContains` 语法 @4ra1n
- [功能] 表达式搜索支持 `classNameNotContains` 语法 @4ra1n
- [BUG] 方法右键预览界面可能由于鼠标位置无法完全显示 @4ra1n
- [BUG] 修复 `LUCENE` 索引创建时超过 `UTF-8` 编码限制 @Gosiu
- [BUG] 修复 `CALL` 部分 `GUI` 放大之后界面过小问题 @4ra1n
- [BUG] 修复 `Spring` 分析结果为空时点击报错的问题 @4ra1n
- [BUG] 处理 `Tomcat` 动态分析日志部分某些情况乱码 @4ra1n
- [BUG] 解决表达式搜索某些情况 `OOM` 以及丢失数据问题 @4ra1n
- [优化] 优化表达式搜索的性能使用更合理的线程池 @4ra1n
- [优化] 优化表达式搜索功能显示实时进度百分比 @4ra1n
- [优化] 优化 `RSyntaxTextArea` 按照实际需求自动拓展大小 @4ra1n
- [优化] 全局 `LUCENE` 搜索加入缓存机制提高搜索效率 @4ra1n
- [优化] 美化 `GUI` 给每个菜单添加对应的图标 @4ra1n
- [优化] 优化 `Spring` 分析部分支持类型显示 @Gosiu
- [优化] 删减依赖并优化 `LUCENE` 索引存储和搜索性能 @Gosiu
- [其他] 升级 `asm/oshi/java-parser` 等依赖到最新 @4ra1n
- [其他] 考虑到 `LTS` 降级内置 `JRE-23` 为 `JRE-21` @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Honey Baby (https://github.com/Gosiu)
- ar3h (https://github.com/ar3h)
- 某匿名安全研究员（提出多条改进建议）

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（激进用户尝试使用）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 4.4

更新日志：

- [功能] 支持不跳转情况下右键预览方法代码
- [BUG] 全局搜索某些不存在的类无法打开且没有报错信息
- [BUG] 某些情况下可能打开非 `class` 文件预期外错误
- [BUG] 全局搜索某些情况会显示非 `class` 文件问题
- [BUG] 修复自定义漏洞搜索配置项过多无法启动的问题
- [优化] 优化 `all strings` 功能字符串过大导致卡顿
- [其他] 更新多个依赖库到最新版

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-23` 版内置开启 `ZGC` 的 `JRE 23` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 4.3

更新日志：
 
- [优化] 使用更美观的黑暗主题颜色组合
- [优化] 自动保存当前使用主题下次启动生效
- [优化] 选中代码高亮时应该忽略空格等空白字符串
- [其他] 升级内置 `JRE` 到 `8u442` 和 `23.0.2`
- [测试功能] 代码区域支持 `ctrl + 左键` 搜索方法

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-23` 版内置开启 `ZGC` 的 `JRE 23` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 4.2

更新日志：

- [重要] 修复字符串搜索无法搜索中文的问题
- [功能] 支持亮/黑暗主题的切换功能
- [BUG] 修复命令行 `build` 也会弹出文件大小提示框的问题
- [优化] 命令行 `build` 新增参数支持 `jars in jar` 情况
- [优化] 查看方法指令代码界面允许放大缩小
- [其他] 更新所有依赖到最新版

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-23` 版内置开启 `ZGC` 的 `JRE 23` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 4.1

搜索字符串增强，支持方法注解/参数注解等所有注解内字符串搜索，可从搜索结果跳转到方法

新功能，当用户需要快速查看，而不想启动耗时的分析引擎时使用内置 `JD-GUI` 程序

修复 `Linux` 不支持某些 `Swing` 特效无法启动，新增 `--skip-load` 参数跳过启动加载

更新日志：

- [重要] 搜索字符串支持所有注解内字符串跳转到方法 @4ra1n
- [重要] 内嵌 `JD-GUI` 项目用于快速查看 @4ra1n
- [BUG] 修复 `linux` 下无法运行的问题 @4ra1n
- [BUG] 修复 `binary search` 搜索重复弹窗问题 @4ra1n
- [BUG] 修复全局搜索主动生成后再被动生成报错 @4ra1n
- [BUG] 修复信息泄露模块的 `IP` 地址检查误报 @4ra1n
- [BUG] 修复某些情况代码区域右键打开文件夹报错 @4ra1n
- [优化] 修复高分辨率下缩放导致 `GUI` 显示不完整的问题 @MyDynasty
- [优化] 优化预期外错误提示信息界面方便用户反馈 @4ra1n
- [优化] 信息泄露模块显示结果根据分类的排序 @4ra1n
- [其他] 升级 `mybatis/dhcp/hutool` 依赖到最新 @4ra1n
- [其他] 修改开源 `LICENSE` 为 `GPLv3` @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- MyDynasty (https://github.com/MyDynasty)
- hacats (https://github.com/hacats)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-23` 版内置开启 `ZGC` 的 `JRE 23` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 4.0

`Jar Analyzer` 发布 `4.0` 版本！

更新多个重要功能，具体内容参考更新日志和 `README` 内容

更新日志：

- [重要] 新增信息泄露检查（部分正则参考 `HaE` 项目）@4ra1n
- [重要] 基于 `Apache Lucene` 的全局搜索 @Gosiu @4ra1n
- [重要] 根据 `YAML` 配置文件动态生成漏洞搜索按钮 @4ra1n
- [重要] 使用 `javaparser` 优化方法跳转的定位 @4ra1n
- [重要] 修复增强批量反编译 `jar` 导出源码功能 @4ra1n
- [重要] 记录每一步操作且可以进行任意前进后退 @4ra1n
- [功能] 菜单 `help` 新增 `quick start` 教程 @4ra1n
- [功能] 新增多个图标图片优化菜单和 `GUI` 界面 @4ra1n
- [功能] 数据库记录 `class` 中所有 `field` 的值 @4ra1n
- [功能] 批量反编译导出 `jar` 功能支持输入目录 @4ra1n
- [功能] 搜索结果筛选空参方法（空参一般不存在漏洞） @4ra1n
- [BUG] 批量反编译导出 `jar` 功能无法指定输入 @4ra1n
- [BUG] 方法跳转定位时内部类定位异常的问题 @4ra1n
- [BUG] 方法跳转定位时构造方法定位异常的问题 @4ra1n
- [BUG] 方法跳转定位时包含注解时定位异常的问题 @4ra1n
- [BUG] 方法展示列表中类构造方法名称为空的问题 @4ra1n
- [BUG] 左下角文件树搜索弹框可能导致 `UI` 不稳定 @4ra1n
- [BUG] 搜索黑名单默认提示文字拼写错误 @4ra1n
- [优化] 批量反编译导出 `jar` 功能给出进度条提示 @4ra1n
- [优化] 优化找不到 `rt.jar` 时给用户的提示信息 @4ra1n
- [优化] 左下角文件树类名过长时鼠标停留显示完整类名 @4ra1n
- [优化] 优化 `clean` 操作删除所有可能的临时文件 @4ra1n
- [优化] 批量反编译导出 `jar` 功能允许直接运行 @4ra1n
- [优化] 优化某些错误代码方法定位时报错的处理 @4ra1n
- [其他] 升级 `JRE` 版本到 `8u432` 和 `23.0.1` @4ra1n
- [其他] 升级 `asm/rsyntaxtextarea/flatlaf` 版本到最新 @4ra1n

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Honey Baby (https://github.com/Gosiu)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-23` 版内置开启 `ZGC` 的 `JRE 23` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 3.2

更新日志：

- [功能] 增强 `tomcat` 分析能力（例如 `URL` 信息）
- [功能] 代码区域选中部分右键搜索定位 `class` 位置
- [功能] 搜索界面的类黑名单应该支持包名过滤
- [功能] 搜索结果支持右键复制单个或全部信息到剪贴板
- [功能] 代码区域和文件树区域支持在文件管理器中打开
- [功能] 添加参数禁用所有自动和手动的更新检查
- [BUG] 修复子类 `this.父类方法` 时找不到 `caller`
- [BUG] 修复 `StartUpMessage` 某些情况无法启动
- [BUG] 修复文件树底部搜索区域某些情况下 `UI` 抖动
- [BUG] 修复致谢页面和更新日志在 `mac` 中乱码
- [BUG] 修复 `tomcat` 分析卡住的问题
- [BUG] 修复 `tomcat` 分析找不到某些类的问题
- [BUG] 修复 `tomcat` 分析密码包含特殊字符问题
- [优化] 添加分析 `jar` 时的进度条展示
- [优化] 优化黑白名单输入解析过程对特殊字符的处理
- [优化] 分析 `tomcat` 时 `socket` 未关闭问题
- [优化] 优化 `tomcat` 分析的命令生成
- [优化] 添加 `tomcat` 分析等待进度条
- [优化] 优化所有的窗口显示位置居中
- [优化] 完善 `Uncaught Exception` 处理
- [优化] 将安全日志单独输出到日志文件
- [优化] 允许文件树搜索内容包含空格输入
- [优化] 给所有没有图标的菜单选项添加默认图标
- [优化] 优化 `sql` 日志文件按日期保存
- [优化] 生成命令时显示 `tomcat` 的配置示例
- [优化] 删除 `tomcat` 分析产生的临时文件
- [其他] `JRE 22` 版本升级 `JRE 23`
- [其他] 升级 `fastjson2/oshi` 版本到最新

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- fantasy (https://github.com/ly-test-fuzz)
- phil (https://github.com/sensensen404)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-23` 版内置开启 `ZGC` 的 `JRE 23` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 3.1

新增两位贡献者，修复和优化了多个问题，新增了一些功能，一处 **破坏性** 变更

内部讨论，为了更好的 **兼容性** 修改远程 `tomcat` 分析功能为 `premain` 方式

更新日志：

- [注意] `tomcat` 分析功能改进为 `premain` 方式
- [功能] 支持一键反编译 `BCEL` 字符串
- [功能] 表达式搜索新增 `excludeAnno` 语法
- [功能] 分析方法时记录行号信息排序时使用
- [功能] 允许配置是否自动修复方法实现和重写
- [BUG] `UBUNTU` 主界面右侧显示不全问题
- [BUG] `UBUNTU CODE` 区域字体过小问题
- [BUG] 修复表达式搜索排序设置无效的问题
- [BUG] 修复 `WEB-INF` 目录处理的问题
- [BUG] 修复 `WAR` 名称没有记录的问题
- [BUG] 修复黑白名单对 `BOOT-INF` 不生效问题
- [优化] 黑白名单配置解析兼容性问题
- [优化] 对 `MAC` 系统的快捷键进行优化
- [优化] 找不到类时提供完善的原理说明和解决
- [优化] 导出代码功能遇到非 `JAR` 增加提示
- [优化] 启动检测 `JAVA` 版本的文字内容优化
- [优化] 启动时默认使用 `INFO` 日志级别
- [优化] 解析 `JAR` 时的逻辑问题和性能优化
- [优化] 优化分析继承关系部分代码的性能
- [优化] 优化分析字符串信息部分代码的性能
- [优化] 黑白名单配置部分在启动后应该锁定
- [优化] 优化黑白名单 `UI` 界面抖动的问题
- [优化] 大幅减小 `agent.jar` 的体积
- [其他] 新增贡献者致谢列表界面
- [其他] `JRE 21` 版本升级 `JRE 22`
- [其他] 升级 `oshi/hutool` 依赖

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- phil (https://github.com/sensensen404)
- fantasy (https://github.com/ly-test-fuzz)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-22` 版内置开启 `ZGC` 的 `JRE 22` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 3.0

`Jar Analyzer` 发布 `3.0` 版本！

更新多个重要功能，多个优化，多个安全改进，删除无意义功能

更新日志：

- [重要] 代码区域支持选中方法名右键搜索调用信息
- [重要] 代码区域支持选中字符串右键搜索相关指令
- [重要] 添加方法记录功能（右键保存至备忘录需要时查看）
- [功能] 支持一键生成当前方法调用的 `HTML` 图
- [功能] 分析历史和记录功能合并到同个 `PANEL` 中
- [功能] 方法记录功能允许删除单个和全部清除
- [功能] 语言切换支持保存重启后读取记录生效
- [功能] 新增 `FreeMarker` 调用的一键搜索
- [功能] 新增 `Aviator` 表达式调用的一键搜索
- [功能] 新增 `JEXL` 表达式调用的一键搜索
- [功能] 新增 `MVEL` 表达式调用的一键搜索
- [功能] 新增 `QLExpress` 表达式调用的一键搜索
- [功能] 新增 `XStream` 反序列化调用的一键搜索
- [功能] 新增多种执行 `SQL` 语句调用的一键搜索
- [功能] 新增 `Rhino` 表达式调用的一件搜索
- [功能] 配置日志 `debug|info|warn|error` 级别
- [BUG] 修复某些情况 `AWT` 线程出现异常报错
- [优化] 代码区域搜索输入框内容变化实时监听搜索
- [优化] 代码区域搜索按 `ENTER` 键切换下一条记录
- [优化] `full` 和 `system` 版本使用 `G1GC`
- [优化] 修改 `Xmx` 和 `Xms` 到更合适的值
- [优化] 自定义 `SecurityManager` 替代 `RASP`
- [优化] 自定义 `ObjectInputFilter` 保护程序
- [优化] 输入 `JAR` 大小不足 `1MB` 的提示优化
- [优化] 启动加入动画效果和 `GUI` 居中显示
- [优化] `API Server` 添加 `favicon.ico`
- [优化] 优化所有不必要的错误日志输出格式
- [其他] 内置 `JRE` 改成 `Eclipse Temurin`
- [其他] 升级 `hutool/flatlaf/slf4j/spring` 依赖
- [其他] 删除修改字节码中方法名的测试功能（无意义）
- [其他] 删除 `CLASS-SEARCHER` 子项目（无意义）

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置开启 `G1GC` 的 `JRE 8` 环境 (**完整版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.24

大幅优化 `SCA` 扫描逻辑，提高扫描效率

更新日志：

- [SCA-重要] 大幅提升 `SCA` 的扫描速度
- [SCA-BUG] SHIRO SCA 扫描包含多个重复的结果
- [SCA-BUG] 修复 `FASTJSON` 漏洞分数的问题
- [SCA-FEAT] 应该只遍历一次 `JAR` 文件以提高效率
- [SCA-FEAT] 分析 `JAR` 代码避免使用递归
- [SCA-FEAT] 压缩 `HTML` 报告的大小
- [BUG] 选中非方法时不会刷新 `CALL/IMPL` 区域
- [BUG] 文件树选择文件某些情况下不在屏幕范围内
- [BUG] 文件树搜索不会自动滚动到高亮文件
- [其他] 简单调整 `UI` 界面

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.23

重要更新：新增 `SCA` 分析模块，输入 `JAR` 即可分析得到匹配的 `CVE` 漏洞

更新日志：

- [重要] 支持了 `SCA` 检测
- [功能] 反编译代码展示应该自动在文件树选中
- [SCA] 支持 `Apache Log4j2` 全版本的匹配
- [SCA] 支持 `Apache Shiro` 全版本的匹配
- [SCA] 支持 `FASTJSON 1.X` 几乎全版本的匹配
- [SCA] 支持 `ASSEMBLY JAR` 和 `LIB JAR` 两种检测
- [SCA] 内置常见的 `CVE` 漏洞和描述信息用于报告
- [SCA] 支持一键导出 `HTML` 漏洞报告
- [BUG] 文件数区域搜索 `SPRINGBOOT` 项目报错问题
- [BUG] 代码区域空搜索导致卡死的问题
- [BUG] 批量反编译代码没有加载 `JAR` 时报错问题
- [BUG] 修复某些情况代码树搜索框不完全显示的问题
- [优化] 优化代码区域搜索界面和搜索高亮展示方式
- [优化] 整体优化 `GUI` 排列布局
- [优化] 优化批量反编译功能的用户体验
- [优化] 优化未加载 `JAR` 时各种搜索的报错
- [优化] 优化黑白名单等配置界面的字体
- [优化] 优化 `SQL` 语句日志输出信息内容
- [优化] 优化某些不必要的日志输出
- [其他] 删除体积巨大的测试文件方便社区贡献
- [其他] 更新依赖

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.22

严重 `BUG` 紧急修复版本

更新日志：

- [重要] `Illegal group reference` 报错
- [BUG] 构建数据库的效率过低（不应该构建阶段记录 `SQL` 语句）
- [BUG] 修复 `API Server` 不传参数返回全部数据的问题
- [其他] 增加 `ISSUE` 模板修改跳转链接
- [其他] 更新 `attach.dll` 和 `tools.jar` 到最新

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.21

重要更新: 分析时已支持类和包名的白名单，增加文件数部分的搜索

- 包名的黑白名单应该是 `com.test.` 以 `.` 结尾表示包名
- 类名的黑白名单应该是 `com.test.Test` 完整类名
- 先判断白名单后判断黑名单，同时生效

更新日志：

- [重要] 分析时支持类和包名的白名单
- [重要] 允许左侧文件树 `CTRL+F` 搜索类名高亮展示
- [功能] 允许分析 `Spring` 根据 `Path` 搜索
- [功能] 新增内置启用 `ZGC` 的 `JAVA 21` 的版本
- [BUG] 修复某些情况下数据库覆盖的问题
- [BUG] 修复 `API` 返回 `JSON` 过大的报错
- [BUG] 修复某些情况下文件树没有高亮显示的问题
- [优化] 优化 `API` 返回 `JSON` 的大小
- [优化] 数据量巨大时某些功能可能的内存溢出
- [优化] 优化黑名单白名单的解析和配置语法
- [优化] 日志界面支持多种级别和彩色显示
- [优化] `API Server` 启动检查端口冲突
- [优化] 简单优化 `UI` 界面
- [优化] 默认开启 `SQL` 语句执行记录
- [其他] 启动时打印贡献者名单致谢
- [其他] 更新内置 `JRE` 到 `8u422`
- [其他] 修复 `CHANGELOG` 错误的描述
- [其他] 引入 `hutool` 工具包
- [其他] 升级依赖到最新

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Honey Baby (https://github.com/Gosiu)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-full-21` 版内置开启 `ZGC` 的 `JRE 21` 环境（仅包含核心功能）
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

一般推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.20

高亮显示已选中的字符串，优化用户体验

修复表达式搜索结果不完全的问题（并发问题）

更新日志：

- [重要] 支持代码区域选中的字符串全局高亮显示
- [功能] 代码区域使用更美观的字体
- [BUG] 表达式搜索同时包含类和方法注解时搜索不准确
- [BUG] 表达式搜索进度条可能出现除0问题
- [BUG] 远程分析 `JAR` 目录不存在时不可用
- [BUG] 远程分析 `JAR` 的 `UI` 界面可能卡死
- [BUG] 某些情况下检查输入大小会得到 `0` 的结果
- [其他] 升级依赖到最新版

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.19

新增多个皮肤，新增实时系统信息折线图，修复了一些已知问题

更新日志：

- [功能] 实时折线图展示 `CPU` 和内存占用
- [功能] 分析目标前检查总输入大小并提醒
- [功能] 启动时支持十种 `UI` 主题选择
- [BUG] 修复某些情况下 `SPEL` 搜索卡住
- [BUG] 修复 `Tomcat` 远程分析无法使用问题
- [BUG] 修复某些情况下某些功能预期外的行为
- [优化] 优化界面上对于两种黑名单的用法提示
- [优化] 优化所有的 `JFrame` 显示位置
- [优化] 启动时检查 `Java` 版本做出对应提示
- [优化] 优化启动脚本和某些 `JVM` 参数
- [优化] 优化菜单
- [其他] 彩蛋

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.18

新版本检查不再使用独立服务器了，成本过高，现在使用 `OSS` 方式

新提供了 `HTTP API` 查询分析结果，参考 `README` 页面

更新日志：

- [功能] 提供 `HTTP API` 查询分析结果
- [BUG] 修复第一次启动可能的 `UnsatisfiedLinkError`
- [BUG] 修复手动检查更新不可用时卡死的问题
- [优化] 使用 `OSS` 替换更新服务器降低成本
- [优化] 删除某些不常用的库和插件
- [优化] 应该开启二级缓存提高查询效率
- [其他] 升级依赖

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.17

更新日志：

- [重要] 支持远程字节码指令级的单步调试
- [重要] 支持从序列化数据一键提取恶意代码
- [BUG] 修复高版本 `JDK` 在 `WINDOWS` 无法启动的问题
- [优化] 合并和优化某些菜单选项
- [其他] 升级某些依赖版本

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.16

支持通过 `export java` 菜单一键导出反编译后的 `JAVA` 代码

安全公告：[GHSA-jmcg-r2c5-7m29](https://github.com/jar-analyzer/jar-analyzer/security/advisories/GHSA-jmcg-r2c5-7m29)

更新日志：

- [安全] 修复处理 `JAR` 时存在的 `ZIP SLIP` 漏洞
- [功能] 支持一键导出反编译后的 `JAVA` 代码
- [功能] 新增代理面板支持 `HTTP/SOCKS` 等代理
- [功能] 支持根据实际情况动态设置数据库保存分区大小
- [BUG] 忽略 `FERN FLOWER` 反编译报错终止问题
- [BUG] 修复多屏时搜索框和远程加载框位置问题
- [BUG] 解决输入的 `URL` 为空时报错
- [优化] 保留编译信息允许用户进行调试
- [优化] 补充没有 `ICON` 信息的菜单选项
- [优化] 菜单部分的合并和优化

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.15

更新日志：

- [重要] 代码区域支持 `Ctrl+F` 搜索
- [重要] 支持通过 `HTTP` 远程加载
- [BUG] 启动 `logo` 拼写错误问题
- [优化] 优化命令行参数解析和处理部分代码
- [优化] 删除 `zip` 版本中不必要的文件
- [优化] 默认搜索选项改为模糊和调用搜索
- [优化] 取消打印 `gc` 信息以提升性能
- [优化] 使用稳定的 `okhttp` 代替轮子
- [其他] 更新依赖库到最新版
- [其他] 更新内置`JRE` 到 `8u412`
- [其他] 更换 `UI` 界面的作者头像
- [其他] 更新 `license` 时间信息

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- xishir (https://github.com/xishir)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.14

重构了 `UI` 允许放大和全屏显示

安全公告：[GHSA-x5h2-78p8-w943](https://github.com/jar-analyzer/jar-analyzer/security/advisories/GHSA-x5h2-78p8-w943)

更新日志：

- [重要] 重构 `UI` 允许放大和全屏显示
- [安全] 修复了几处 `SQL` 注入漏洞
- [其他] 更新 `flatlaf` 和 `asm` 到最新版
- [其他] 更新 `maven` 插件到最新版

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.13

更新日志：

- [功能] 提供 `Windows` 版本的启动 `EXE`
- [其他] 完善和优化 `README` 文档

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.12

该版本更新内容较多，主要支持了原 `V1` 版本灵活的 `SPEL` 表达式搜索，但当数据过大时分析速度明显下降，之后的版本会尝试提高；
另外删除了对 `Linux` 的专门版本，对于非 `Windows` 用户统一使用 `JAR` 版本即可，该版本保留了绝大多数核心的功能；

更新日志：

- [重要] 支持表达式搜索（用法参考 `README` 文档）
- [功能] 支持开启记录所有 `SQL` 语句到日志文件
- [BUG] 修复分析新 `JAR` 时不会刷新文件树的问题
- [优化] 使用 `ConcurrentLinkedQueue` 解决并发问题
- [优化] 使用阻塞队列线程池加速表达式搜索
- [其他] 修改发布 `JAR` 版本变成 `ZIP` 版本
- [其他] 更新内置 `JRE` 版本为 `zulu-8u402`
- [其他] 更新发布类型（删除 `linux` 版增加 `zip` 版）
- [其他] 完善 `CI` 对所有子项目进行测试

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Gauss Zhou (https://github.com/gausszhou)

所有可供下载的文件都由 `Github Actions` 构建，提供以下三种:

- `windows-full` 版内置 `JRE 8` 环境 (**完整功能版本**)
- `windows-system` 版使用系统 `JRE` 的启动脚本 (推荐安装 `JRE/JDK 8`)
- `zip` 版仅包含简单的 `jar` 文件 (使用 `java -jar` 启动)

推荐使用 `windows-full` 版，包含完整功能，其他版本某些功能**可能**不可用

如果你是 `ubuntu/mac` 用户请使用 `zip` 版本（**核心功能**可以正常使用）

## 2.11

更新日志：

- [功能] 支持中英文界面切换
- [优化] 非`windows`打开`tomcat-analyzer`给出警告
- [优化] 所有代码使用统一的`ASM9`版本
- [优化] 所有代码使用统一的`ASN Flags`设置
- [其他] 升级`rsyntaxtextarea`和`slf4j`版本
- [其他] 升级`flatlaf`到`3.4`版本
- [其他] 升级`actions/cache`到`v4`版本
- [其他] 界面一处拼写错误

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- 推荐 `embed` 版内置 `JRE 8` 的启动脚本 (**无需另外安装一键启动**)
- `system` 使用系统 `JDK` 的启动脚本 (需要自行安装 `JDK`)
- `linux` 内置 `shell` 启动脚本 (需要自行安装 `JDK/JRE`)
- 简单的 `jar` 文件，不提供启动脚本 (使用 `java -jar` 启动)

推荐使用 `embed` 版，经过了较多测试，完善支持 `tomcat-analyzer` 模块

## 2.10

更新日志：

- [功能] 分析`Spring`时根据`Controller`注解显示完整路径
- [功能] 支持在`config`菜单配置按方法名/类名对结果进行排序
- [优化] 删除`JNA`库自行实现具体的功能大幅减小体积
- [优化] 搜索结果为空时不应该跳转页面
- [优化] 搜索到结果时应该提示搜索到结果数量
- [优化] 不显示临时文件里的`dll`本地库文件
- [其他] 升级`flatlaf`到`3.3`版本
- [其他] 升级`maven.compiler`插件到`3.12.1`版本
- [其他] 优化代码`import`并完全格式化

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- veo (https://github.com/veo)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- 推荐 `embed` 版内置 `JRE 8` 的启动脚本 (**无需另外安装一键启动**)
- `system` 使用系统 `JDK` 的启动脚本 (需要自行安装 `JDK`)
- `linux` 内置 `shell` 启动脚本 (需要自行安装 `JDK/JRE`)
- 简单的 `jar` 文件，不提供启动脚本 (使用 `java -jar` 启动)

推荐使用 `embed` 版，经过了较多测试，完善支持 `tomcat-analyzer` 模块

## 2.9

安全更新，修复了一处比较严重的拒绝服务漏洞

安全公告：[GHSA-43rf-3hm4-hv5f](https://github.com/jar-analyzer/jar-analyzer/security/advisories/GHSA-43rf-3hm4-hv5f)

更新日志：

- [安全] 修复`HackingFernFlower`提出的拒绝服务漏洞
- [功能] 支持`Hessian`反序列化一键搜索
- [功能] 支持可能的解压操作一键搜索(`Zip Slip`相关)
- [BUG] 解决不可读字符串导致的`NullPointerException`
- [BUG] 使用`JNA`解决部分`Windows`颜色显示问题
- [优化] 使用`Github Actions`构建
- [优化] 整体优化错误日志的输出
- [Y4-HTTP] 修复响应不含`reason`时解析报错
- [Y4-LANG] 暂时删除`java`版的`y4-lang`
- [其他] 升级第三方组件版本到最新稳定

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)
- Y4tacker (https://github.com/Y4tacker)

所有可供下载的文件都由 `Github Actions` 构建，提供以下四种:

- 推荐 `embed` 版内置 `JRE 8` 的启动脚本 (**无需另外安装一键启动**)
- `system` 使用系统 `JDK` 的启动脚本 (需要自行安装 `JDK`)
- `linux` 内置 `shell` 启动脚本 (需要自行安装 `JDK/JRE`)
- 简单的 `jar` 文件，不提供启动脚本 (使用 `java -jar` 启动)

推荐使用 `embed` 版，经过了较多测试，完善支持 `tomcat-analyzer` 模块

## 2.8

更新日志：

- [重要] 集成`tomcat-analyzer`项目
- [重要] 支持执行`Y4Lang`脚本语言
- [安全] 阻止`SQLITE`执行`ATTACH`语句
- [BUG] 修复某些情况下程序无法启动的问题
- [BUG] 修复手动查看最新版空指针问题
- [优化] 每次新执行`SQL`语句应该清空报错
- [优化] 解决每次启动多次初始化`UI`的问题
- [优化] 编译去除调试信息缩小`JAR`文件
- [优化] 将`System.err`报错也记录在日志
- [Y4-LOG] 修复无调试信息时行号记录问题
- [Y4-LANG] 修复临时目录不存在时的报错
- [其他] 升级第三方组件版本到最新稳定

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

在 `release` 中提供四种下载:

- 推荐 `embed` 版内置 `JRE 8` 的启动脚本 (**无需另外安装一键启动**)
- `system` 使用系统 `JDK/JRE` 的启动脚本 (需要自行安装 `JDK/JRE`)
- `linux` 内置 `shell` 启动脚本 (需要自行安装 `JDK/JRE`)
- 简单的 `jar` 文件，不提供启动脚本 (使用 `java -jar` 启动)

推荐使用 `embed` 版，经过了较多测试，完善支持 `tomcat-analyzer` 模块

## 2.7

正式版本 `2.7` 发布

更新日志:

- [功能] 支持多种`FASTJSON`调用一键搜索 #17
- [功能] 支持命令行方式构建数据库 #13
- [功能] 添加快捷键`Ctrl+X`跳转方法调用界面 #16
- [功能] 新增显示内部类和自动修复类路径的配置
- [功能] 支持修改方法名称并修改对应的引用
- [BUG] 解决某些情况下双击方法区域的空指针
- [BUG] 解决某些情况下查到类方法数量是空的问题
- [BUG] 当字符串列表巨大时点击查看程序会卡死 #14
- [BUG] 当添加`RT.JAR`分析后不会记录输入`JAR`文件 #15
- [BUG] 编码解码工具中`Base64`部分按钮错误
- [BUG] 当不存在配置文件时`GPT`无法打开
- [优化] 优化`SimpleFrame`中对`null`的显示
- [优化] 优化一些按钮的停留提示内容
- [优化] 字符串列表支持分页和去重排序等优化
- [优化] 优化启动脚本加入`DisableAttachMechanism`
- [优化] 优化各种分析功能获取类文件的逻辑
- [Y4-LOG] 内置`Y4-LOG`库支持写入日志文件
- [其他] 更新B站教程视频

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

在 `release` 中提供四种下载:

- `system` 使用系统 `JDK/JRE` 的启动脚本 (需要自行安装 `JDK/JRE`)
- `embed` 内置 `JRE 8` 的启动脚本 (**无需另外安装一键启动**)
- `linux` 内置 `shell` 启动脚本 (需要自行安装 `JDK/JRE`)
- 简单的 `Jar` 文件，不提供启动脚本 (使用 `java -jar` 启动)

## 2.6-beta

该版本没有大功能更新，但大幅减小了体积

自己实现`json`序列化反序列化，以及`http`和`log`库进一步减小体积

内置简化`sqlite`驱动，可减小`50%`体积，仅保留以下`native`库:

- `linux x86_64`
- `windows x86_86`
- `mac aarch64`和`mac x86_64`

更新日志:

- [功能] 支持拖拽`jar`文件到`GUI`界面
- [功能] 增加`Show String`按钮查看所有字符串
- [功能] 增加`clean`按钮一键清除临时文件
- [功能] 增加`ChatGPT`插件并支持保存配置
- [BUG] 同目录只允许运行一个实例防止数据冲突
- [优化] 内置`sqlite`驱动删除不必要的部分
- [优化] 优化反编译部分的`LRU`缓存代码
- [Y4-JSON] 内置`Y4-JSON`库代替原`Fastjson`库
- [Y4-HTTP] 内置`Y4-HTTP`库代替原`http`库
- [Y4-LOG] 内置`Y4-LOG`库代替原`Log4j2`库
- [JRE] 使用更稳定的`Zulu JRE`支持内置版本
- [其他] 支持了英文版的文档

感谢以下用户的贡献:

- 4ra1n (https://github.com/4ra1n)

在 `release` 中提供四种下载:

- `system` 使用系统 `JDK/JRE` 的启动脚本 (需要自行安装 `JDK/JRE`)
- `embed` 内置 `JRE 8` 的启动脚本 (**无需另外安装一键启动**)
- `linux` 内置 `shell` 启动脚本 (需要自行安装 `JDK/JRE`)
- 简单的 `Jar` 文件，不提供启动脚本 (使用 `java -jar` 启动)

## 2.5-beta

- [重要] 支持编写自定义`SQL`语句查询
- [BUG] 切换搜索模式时应该清空无效字段
- [优化] 反编译代码功能使用`LRU`缓存优化
- [优化] 解决某些情况下`UI`抖动的问题
- [优化] 不应该显示`access$`私有成员辅助方法
- [其他] 使用`properties`替换`yaml`减小体积
- [其他] 升级`sqlite-jdbc`和`log4j2`到最新版
- [其他] 删除意义不大的`chatgpt`模块
- [其他] 升级内置`Y4 JRE`到`1.8.0_402-b01`
- [其他] `README`加入解决中文乱码的办法

感谢以下用户的帮助和贡献：

- alwaystest

## 2.4-beta

- [功能] 支持`Runtime.exec`和`ProcessBuilder.start`一键搜索
- [功能] 支持`JNDI`漏洞`Context.lookup`一键搜索
- [功能] 支持`readObject`和`ScriptEngine.eval`一键搜索
- [功能] 支持`BCEL.loadClass`和`defineClass`一键搜索
- [功能] 支持`SPEL`和`OGNL`的一键搜索
- [功能] 支持手动刷新`spring`分析结果
- [BUG] 修复输入`classname`为`null`时的空指针
- [BUG] 修复在分析部分类的时候发生空指针异常的问题
- [BUG] 在使用`Lambda/Streamd/Runnable`等特性时丢失分析结果 #8
- [优化] 优化搜索结果为空时的用户体验
- [优化] 优化检查最新版本中的`json`解析代码
- [优化] 使用单独的服务器验证最新版避免`github api`访问不到
- [优化] 自行实现`http`库代替`okhttp`减小体积
- [其他] 代码格式化以及优化代码`import`部分
- [其他] 加大`CHANGELOG`的宽度以完全显示

感谢以下用户的帮助和贡献：

- whwlsfb
- wouijvziqy

## 2.3-beta

- [重要] 增加分析前指定包名或类名黑名单配置 #6
- [重要] 增加`frame`中对象哈希追踪分析
- [BUG] 修复分析`frame`时偶尔`class-not-found`
- [BUG] 某些UI逻辑有问题，提升用户体验
- [优化] 搜索界面UI优化并添加部分中文提示
- [优化] 使用`fernflower`源码替换第三方库
- [其他] 更新日志应该按照从新到老的顺序
- [其他] 使用`versions`插件自动检查依赖版本
- [其他] 使用`log4j-iostreams`优化日志
- [其他] 代码重构并升级所有依赖版本到最新稳定版
- [其他] 内置`jre`更新到`y4-jre-1.8.0_392-b03`

## 2.2-beta

- [重要] 支持搜索时配置类名黑名单对结果进行过滤
- [重要] 支持搜索时选择`like`和`equals`两种模式
- [重要] 支持前后跳转：返回上一步和回到当前
- [功能] 程序内提供更新日志，集成`markdown`解析库
- [BUG] 分析`spring`由于`path`为空导致的`BUG` #5
- [优化] 删除某些巨大的依赖库并计划自行实现
- [优化] 搜索输入类名优化，支持`.`替换为`/`字符
- [其他] 删除不必要代码以及简单优化已有代码

## 2.1-beta

- [重要] 支持分析`spring controller`和`mapping`
- [BUG] 解决`mac/ubuntu`中`cfg/frame`分析乱码
- [功能] 支持选择`classes`目录进行分析
- [功能] 内置`consolas`字体启动时自动注册
- [功能] 启动时通过`github`的`api`检查更新
- [其他] 简单的性能和用户体验的优化
- [其他] 不再使用`exe`版本而是使用`bat/sh`脚本启动
- [其他] 发布`release`将包含`win`和`linux(ubuntu)`两种

## 2.0-beta

first release
