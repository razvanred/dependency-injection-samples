//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

let COMMAND_KEY_HELLO_WORLD = "hello"

class HelloWorldCommand : Command {
    
    var key: String { return COMMAND_KEY_HELLO_WORLD }
    
    func handleInput(input: [String]) -> Status {
        if(!input.isEmpty) {
            return Status.invalid
        }
        print("world!")
        return Status.handled
    }
}
