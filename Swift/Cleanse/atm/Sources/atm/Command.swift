//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

protocol Command {
    
    var key: String { get }
    
    func handle(input: [String]) -> Result

}

struct Result {
    
    let status: Status
    let nestedCommandRouter: CommandRouter?
    
    private init(status: Status, nestedCommandRouter: CommandRouter? = nil) {
        self.status = status
        self.nestedCommandRouter = nestedCommandRouter
    }
    
    static func handled() -> Result {
        Result(status: .handled)
    }
    
    static func inputCompleted() -> Result {
        Result(status: .inputCompleted)
    }
    
    static func invalid() -> Result {
        Result(status: .invalid)
    }
    
    static func enterNestedCommandSet(router: CommandRouter) -> Result {
        Result(status: .handled, nestedCommandRouter: router)
    }
    
}

extension Result {
    
    @inlinable public var isInvalid: Bool { status == Status.invalid }
    
    @inlinable public var isHandled: Bool { status == Status.handled }
    
    @inlinable public var isInputCompleted: Bool { status == Status.inputCompleted }
    
}

enum Status {
    case invalid
    case handled
    case inputCompleted
}
