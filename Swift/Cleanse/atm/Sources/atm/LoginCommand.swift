//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation

let COMMAND_KEY_LOGIN = "login"

struct LoginCommand : SingleArgCommand {
    
    private let outputter: Outputter
    private let database: Database
    
    init(outputter: Outputter, database: Database) {
        self.outputter = outputter
        self.database = database
    }
    
    var key: String { return COMMAND_KEY_LOGIN }
    
    func handle(arg: String) -> Status {
        let account = database.getAccount(username: arg)
        outputter.output("\(account.username) is logged in with balance: \(account.balance)")
        return Status.handled
    }
}
