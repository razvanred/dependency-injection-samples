//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 30/07/2020.
//

import Foundation

class CommandProcessor {
    
    private var commandRouterStack = ArrayDeque<CommandRouter>()
    
    init(firstCommandRouter: CommandRouter) {
        commandRouterStack.push(firstCommandRouter)
    }
    
    func process(input: String) -> Status {
        
        if let router = commandRouterStack.peek() {
            
            let result = router.route(input: input)
            
            if result.isInputCompleted {
                commandRouterStack.pop()
                
                return commandRouterStack.isEmpty
                    ? Status.inputCompleted
                    : Status.handled
            }
            
            if let nestedCommandRouter = result.nestedCommandRouter {
                commandRouterStack.push(nestedCommandRouter)
            }
            
            return result.status
        }
        
        return Status.invalid
    }
    
}
