import Foundation
import Cleanse

let commandProcessor = CommandProcessorFactory.processor()

while(true) {
    commandProcessor.process(input: readLine()!)
}
