//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

let COMMAND_KEY_LOGIN = "login"

class LoginCommand : SingleArgCommand {
    
    private let outputter: Outputter
    
    var key: String { return COMMAND_KEY_LOGIN }
    
    init(outputter: Outputter) {
        self.outputter = outputter
    }
    
    func handle(arg: String) -> Status {
        outputter.output("Logged in as \(arg)")
        return Status.handled
    }
}
