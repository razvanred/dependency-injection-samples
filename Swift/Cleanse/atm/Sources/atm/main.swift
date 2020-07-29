import Foundation
import Cleanse

let commandRouter = CommandRouterFactory.create()

while(true) {
    commandRouter.process(input: readLine()!)
}
