import it.skrape.core.htmlDocument
import it.skrape.fetcher.*
import it.skrape.matchers.toBe
import it.skrape.selects.eachSrc
import it.skrape.selects.eachText
import it.skrape.selects.html5.span
import it.skrape.selects.text

fun main() {

    data class Quote(
        var author: String = "",
        var text: String = "",
        var tags: List<String> = emptyList(),
        var about: String = ""
    )

    val data = skrape(HttpFetcher) {
        request {
            url = "https://quotes.toscrape.com/"
        }


        extractIt<Quote> {
            htmlDocument {
                it.text = ".quote .text" {
                    findFirst {
                        text
                    }
                }

                it.author = ".quote .author" {
                    findFirst {
                        text
                    }
                }

                it.about = ".quote a" {
                    findFirst {
                        text toBe "(about)"
                        attribute("href")
                    }
                }

                it.tags = ".quote" {
                    findFirst {
                        ".tag" {
                            findAll {
                                eachText
                            }
                        }
                    }
                }
            }
        }

    }

    println(data)
    println("gotten data")
}