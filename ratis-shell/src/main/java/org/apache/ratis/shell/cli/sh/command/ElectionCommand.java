/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ratis.shell.cli.sh.command;

import org.apache.ratis.shell.cli.sh.election.PauseCommand;
import org.apache.ratis.shell.cli.sh.election.ResumeCommand;
import org.apache.ratis.shell.cli.sh.election.StepDownCommand;
import org.apache.ratis.shell.cli.sh.election.TransferCommand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class ElectionCommand extends AbstractParentCommand {
  private static final List<Function<Context, AbstractRatisCommand>> SUB_COMMAND_CONSTRUCTORS
      = Collections.unmodifiableList(Arrays.asList(
      TransferCommand::new, StepDownCommand::new, PauseCommand::new, ResumeCommand::new));

  /**
   * @param context command context
   */
  public ElectionCommand(Context context) {
    super(context, SUB_COMMAND_CONSTRUCTORS);
  }

  @Override
  public String getCommandName() {
    return "election";
  }

  @Override
  public String getDescription() {
    return description();
  }

  /**
   * @return command's description
   */
  public static String description() {
    return "Manage ratis leader election; see the sub-commands for the details.";
  }
}
