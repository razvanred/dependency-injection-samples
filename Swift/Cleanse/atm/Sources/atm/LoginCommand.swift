//
//  File.swift
//  
//
//  Created by Răzvan Roşu on 29/07/2020.
//

import Foundation
import Cleanse

let COMMAND_KEY_LOGIN = "login"

struct LoginCommand : SingleArgCommand {
    
    private let outputter: Outputter
    private let database: Database
    private let userCommandsRouterFactory: ComponentFactory<UserCommandsRouter>
    
    init(outputter: Outputter, database: Database, userCommandsRouterFactory: ComponentFactory<UserCommandsRouter>) {
        self.outputter = outputter
        self.database = database
        self.userCommandsRouterFactory = userCommandsRouterFactory
    }
    
    var key: String { COMMAND_KEY_LOGIN }
    
    func handle(arg: String) -> Result {
        let account = database.getAccount(username: arg)
        outputter.output("\(account.username) is logged in with balance: \(account.balance)")
        return Result.enterNestedCommandSet(router: userCommandsRouterFactory.build(account))
    }
}
