//import it.skrape.core.htmlDocument
//import it.skrape.selects.and
//import it.skrape.selects.eachImage
//import it.skrape.selects.eachText
//import it.skrape.selects.html5.a
//import it.skrape.selects.html5.div
//import it.skrape.selects.html5.p
//import it.skrape.selects.html5.span
//import org.junit.jupiter.api.Test
//
//// just some object where we will store our scraped data
//data class MyExtractedData(
//    var httpMessage: String = "",
//    var userName: String = "",
//    var repositoryNames: List<String> = emptyList(),
//    var theThirdRepositoriesName: String = "",
//    var firstThreeHrefs: List<String> = emptyList(),
//    var overviewLink: String = "",
//    var firstThreeImageSources: List<String> = emptyList(),
//    var title: String = "",
//    var starsCount: String = ""
//)
//
//fun main() {
//    val extracted = skrape { // 1️⃣
//        url = "https://github.com/skrapeit"
//
//        extractIt<MyExtractedData> { it ->
//            it.httpMessage = status { message } // 2️⃣
//            htmlDocument { // 3️⃣
//                relaxed = true // 4️⃣
//
//                it.userName = ".h-card .p-nickname" { findFirst { text } } // 5️⃣
//                val repositories = span(".repo") { findAll { this }} // 6️⃣
//                println("hello world") // 7️⃣
//                it.repositoryNames = repositories.filter { it.text.contains("skrape") }.eachText // 8️⃣
//                it.theThirdRepositoriesName = span(".repo") {
//                    2 { text } // 9️⃣
//                }
//                it.firstThreeImageSources = findAll { eachImage.map { image -> image.value } }.take(3) // 1️⃣0️⃣
//                it.firstThreeHrefs = findAll { eachHref }.take(3) // 1️⃣1️⃣
//                it.overviewLink = findAll { eachLink["Overview"] ?: "not found" } // 1️⃣2️⃣
//                it.title = titleText // 1️⃣3️⃣
//
//                // *️⃣
//                it.starsCount = div { // 1️⃣5️⃣
//                    withClass = "pinned-item-list-item"
//                    findFirst {
//                        p { // 1️⃣6️⃣
//                            findSecond {
//                                a {
//                                    // 1️⃣7️⃣
//                                    withClass = "pinned-item-meta" and "muted-link" // 1️⃣8️⃣
//                                    withAttribute = "href" to "/skrapeit/skrape.it/stargazers" // 1️⃣9️⃣
//
//                                    findFirst {
//                                        ownText
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//    println(extracted)
//}