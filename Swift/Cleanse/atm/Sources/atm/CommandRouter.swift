//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

class CommandRouter {
    
    private var commands = [String: Command]()
    private let outputter: Outputter
    
    init(command: Command, outputter: Outputter) {
        commands[command.key] = command
        self.outputter = outputter
    }
    
    func process(input: String) -> Status {
        let inputSplit = input.split()
        
        if(inputSplit.isEmpty) {
            return invalidCommand(input)
        }
        
        let commandKey = inputSplit[0]
        
        if let command = commands[commandKey] {
            let status = command.handleInput(input: Array(inputSplit[1..<inputSplit.count]))
            
            if status == Status.invalid {
                outputter.output("\(commandKey): invalid arguments")
            }
            
            return status
        }
        
        return invalidCommand(input)
    }
    
    private func invalidCommand(_ input: String) -> Status {
        outputter.output("Couldn't understand \"\(input)\". Try again.")
        return Status.invalid
    }
    
}

extension String {
    fileprivate func split() -> [String] {
        components(separatedBy: " ")
    }
}
