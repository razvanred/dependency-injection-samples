//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

let COMMAND_KEY_HELLO_WORLD = "hello"

struct HelloWorldCommand : NoArgsCommand {
    
    let outputter: Outputter
    
    init(outputter: Outputter) {
        self.outputter = outputter
    }
    
    var key: String { COMMAND_KEY_HELLO_WORLD }
    
    func handle() -> Result {
        outputter.output("world!")
        return Result.handled()
    }
}
