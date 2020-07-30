//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

struct CommandRouter {
    
    private let commands: [String: Command]
    private let outputter: Outputter
    
    init(commands: [Command], outputter: Outputter) {
        self.commands = commands.toDictionary()
        self.outputter = outputter
    }
    
    func process(input: String) -> Status {
        let inputSplit = input.split()
        
        if(inputSplit.isEmpty) {
            return invalidCommand(input)
        }
        
        let commandKey = inputSplit[0]
        
        if let command = commands[commandKey] {
            let status = command.handle(input: Array(inputSplit[1..<inputSplit.count]))
            
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

extension Array where Element == Command {
    fileprivate func toDictionary() -> [String: Command] {
        reduce(into: [String: Command](), { acc, act in
            acc[act.key] = act
        })
    }
}
