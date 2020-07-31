//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 31/07/2020.
//

import Foundation

let COMMAND_KEY_LOGOUT = "logout"

struct LogoutCommand : NoArgsCommand {
    
    private let outputter: Outputter
    
    init(outputter: Outputter) {
        self.outputter = outputter
    }
    
    func handle() -> Result {
        outputter.output("Logging out...")
        return Result.inputCompleted()
    }
    
    var key: String { COMMAND_KEY_LOGOUT }
}
